package by.sidina.it_shop.model.user;

import by.sidina.it_shop.model.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_role")
public class UserRole extends AbstractEntity {
    @Column(name = "role")
    private String userRole;

    public UserRole() {
    }

    public UserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
