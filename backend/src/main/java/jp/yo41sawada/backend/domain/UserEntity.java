package jp.yo41sawada.backend.domain;

import jp.yo41sawada.backend.model.User;
import jp.yo41sawada.backend.presentation.UserCsv;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

/**
 * UserEntity
 */
@Table(name = "user")
public class UserEntity {

    @Id
    private Integer id;

    private String firstName;

    private String lastName;

    private User.StatusEnum status;

    public UserEntity(Integer id, String firstName, String lastName, User.StatusEnum status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
    }

    public static UserEntity from(User user) {
        return new UserEntity(user.getId(), user.getFirstName(), user.getLastName(), user.getStatus());
    }

    public static UserEntity from(UserCsv user) {
        return new UserEntity(user.getId(), user.getFirstName(), user.getLastName(), user.getStatus());
    }


    public User toModel() {
        return new User().id(this.id).lastName(this.lastName).firstName(this.firstName).status(this.status);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        UserEntity that = (UserEntity) o;

        if (!Objects.equals(id, that.id))
            return false;
        if (!Objects.equals(firstName, that.firstName))
            return false;
        if (!Objects.equals(lastName, that.lastName))
            return false;
        return Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}
