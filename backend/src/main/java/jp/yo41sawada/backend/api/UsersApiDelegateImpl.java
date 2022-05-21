package jp.yo41sawada.backend.api;

import jp.yo41sawada.backend.api.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsersApiDelegateImpl implements UsersApiDelegate {
    @Override
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(List.of(new User().id(1)));
    }

    @Override
    public ResponseEntity<User> getUser(Integer id) {
        return ResponseEntity.ok(new User().id(1));
    }

}
