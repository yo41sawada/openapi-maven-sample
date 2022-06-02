package jp.yo41sawada.backend.presentation;

import jp.yo41sawada.backend.api.UsersApiDelegate;
import jp.yo41sawada.backend.domain.UserRepository;
import jp.yo41sawada.backend.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsersApiDelegateImpl implements UsersApiDelegate {
    @NonNull
    private final UserRepository planRepository;

    @Autowired
    public UsersApiDelegateImpl(UserRepository planRepository) {
        this.planRepository = planRepository;
    }

    @Override
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = (List<User>) planRepository.findAll();
        return ResponseEntity.ok().body(users);
    }

}