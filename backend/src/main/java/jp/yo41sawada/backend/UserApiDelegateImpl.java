package jp.yo41sawada.backend;

import jp.yo41sawada.backend.api.UserApiDelegate;
import jp.yo41sawada.backend.model.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UserApiDelegateImpl implements UserApiDelegate {
    @Override
    public ResponseEntity<Void> userPost(User user) {
        System.out.println("userPost has called.");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}