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
import com.opencsv.CSVReaderBuilder;
import com.opencsv.RFC4180Parser;
import com.opencsv.RFC4180ParserBuilder;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

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
    public ResponseEntity<Void> postCsv(String body) {
        final LineNumberReader lnr = new LineNumberReader(new StringReader(body));

        final RFC4180Parser rfc4180Parser = new RFC4180ParserBuilder()
                .withSeparator(',')
                .build();
        final CSVReader csvReader = new CSVReaderBuilder(lnr)
                .withCSVParser(rfc4180Parser)
                .build();
        CsvToBean<UserEntity> csvToBean = new CsvToBeanBuilder<UserEntity>(csvReader)
                .withType(UserEntity.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        List<UserEntity> users = csvToBean.parse();
        for (var user : users) {
            System.out.println(user.toString());
            // userRepository.save(MemberEntity.from(member));
        }
        // users.stream().forEach(u -> userRepository.save(UserEntity.from(u)));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}