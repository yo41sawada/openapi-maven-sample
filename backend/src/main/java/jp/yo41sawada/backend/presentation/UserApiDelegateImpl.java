package jp.yo41sawada.backend.presentation;

import jp.yo41sawada.backend.api.UserApiDelegate;
import jp.yo41sawada.backend.domain.UserRepository;
import jp.yo41sawada.backend.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class UserApiDelegateImpl implements UserApiDelegate {
    @NonNull
    private final UserRepository planRepository;

    @Autowired
    public UserApiDelegateImpl(UserRepository planRepository) {
        this.planRepository = planRepository;
    }

    @Override
    public ResponseEntity<Void> userPost(User user) {
        System.out.println("userPost has called.");
        user.setId(10);
        user.setFirstName("firstName 10");
        user.setLastName("lastName 10");
        planRepository.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}