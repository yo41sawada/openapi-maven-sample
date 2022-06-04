package jp.yo41sawada.backend.presentation;

import jp.yo41sawada.backend.api.UsersApiDelegate;
import jp.yo41sawada.backend.domain.UserEntity;
import jp.yo41sawada.backend.domain.UserRepository;
import jp.yo41sawada.backend.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsersApiDelegateImpl implements UsersApiDelegate {
    @NonNull
    private final UserRepository planRepository;

    @Autowired
    public UsersApiDelegateImpl(UserRepository userRepository) {
        this.planRepository = userRepository;
    }

    @Override
    public ResponseEntity<List<User>> getUsers() {
        List<UserEntity> users = (List<UserEntity>) planRepository.findAll();
        return ResponseEntity.ok().body(users.stream().map(UserEntity::toModel).collect(Collectors.toList()));
    }

}