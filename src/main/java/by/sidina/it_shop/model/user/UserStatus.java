package by.sidina.it_shop.model.user;

import by.sidina.it_shop.model.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_status")
public class UserStatus extends AbstractEntity {
    @Column(name = "status")
    private String userStatus;

    public UserStatus() {
    }

    public UserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }
}
