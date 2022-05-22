package jp.yo41sawada.backend;

import jp.yo41sawada.backend.api.UsersApiDelegate;
import jp.yo41sawada.backend.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsersApiDelegateImpl implements UsersApiDelegate {
    @Override
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(List.of(new User().id(2)));
    }

}