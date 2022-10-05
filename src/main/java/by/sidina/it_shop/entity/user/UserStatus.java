package by.sidina.it_shop.entity.user;

import by.sidina.it_shop.entity.EntityAbstract;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_status")
public class UserStatus extends EntityAbstract {
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
