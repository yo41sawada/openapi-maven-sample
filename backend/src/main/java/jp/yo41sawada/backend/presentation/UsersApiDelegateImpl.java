package jp.yo41sawada.backend.presentation;

import jp.yo41sawada.backend.api.UsersApiDelegate;
import jp.yo41sawada.backend.domain.UserEntity;
import jp.yo41sawada.backend.domain.UserRepository;
import jp.yo41sawada.backend.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;

import java.io.LineNumberReader;
import java.io.StringReader;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsersApiDelegateImpl implements UsersApiDelegate {
    @NonNull
    private final UserRepository userRepository;

    @Autowired
    public UsersApiDelegateImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<List<User>> getUsers() {
        List<UserEntity> users = (List<UserEntity>) userRepository.findAll();
        return ResponseEntity.ok().body(users.stream().map(UserEntity::toModel).collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<Void> createUsersWithCsv(String body) {
        List<UserCsv> users = getUserCsvList(body);
        users.stream().forEach(u -> userRepository.save(UserEntity.from(u)));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    private List<UserCsv> getUserCsvList(String body) {
        CsvHandler csvHandler = new CsvHandler();
        CSVReader csvReader = csvHandler.getCSVReader(new LineNumberReader(new StringReader(body)));
        return csvHandler.getCsvUsers(csvReader);
    }
}