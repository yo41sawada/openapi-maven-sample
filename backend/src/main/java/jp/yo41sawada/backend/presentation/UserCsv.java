package jp.yo41sawada.backend.presentation;

import com.opencsv.bean.CsvBindByName;

import jp.yo41sawada.backend.model.User;

public class UserCsv {

    @CsvBindByName(column = "id")
    private Integer id;

    @CsvBindByName(column = "first_name")
    private String firstName;

    @CsvBindByName(column = "last_name")
    private String lastName;

    private User.StatusEnum status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public User.StatusEnum getStatus() {
        return status;
    }

    public void setStatus(User.StatusEnum status) {
        this.status = status;
    }
}
