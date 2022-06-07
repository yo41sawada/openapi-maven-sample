package jp.yo41sawada.backend.domain;

import jp.yo41sawada.backend.model.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

/**
 * UserEntity
 */
@Table(name = "user")
public class UserEntity {

    @Id
    private final Integer id;

    private final String firstName;

    private final String lastName;

    public UserEntity(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static UserEntity from(User user) {
        return new UserEntity(user.getId(), user.getFirstName(), user.getLastName());
    }

    public User toModel() {
        return new User().id(this.id).lastName(this.lastName).firstName(this.firstName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(firstName, that.firstName)) return false;
        return Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}

