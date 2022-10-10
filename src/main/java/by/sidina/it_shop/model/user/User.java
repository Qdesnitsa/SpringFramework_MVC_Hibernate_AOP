package by.sidina.it_shop.model.user;

import by.sidina.it_shop.model.AbstractEntity;
import by.sidina.it_shop.model.product.AbstractProduct;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends AbstractEntity {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String country;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, optional = false)
    @JoinColumn(name = "user_role_id")
    private UserRole userRole;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, optional = false)
    @JoinColumn(name = "user_status_id")
    private UserStatus userStatus;
    @Transient
    private List<AbstractProduct> listOfProductsInUser;

    public User() {
    }

    public User(String name, String surname, String email, String password, String country, UserRole userRole, UserStatus userStatus) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.country = country;
        this.userRole = userRole;
        this.userStatus = userStatus;
    }

    public void addProductToUser(AbstractProduct product) {
        if (listOfProductsInUser == null) {
            listOfProductsInUser = new ArrayList<>();
        }
        listOfProductsInUser.add(product);
    }

    public void removeProductFromOrder(AbstractProduct product) {
        listOfProductsInUser.remove(product);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public List<AbstractProduct> getListOfProductsInUser() {
        return listOfProductsInUser;
    }

    public void setListOfProductsInUser(List<AbstractProduct> listOfProductsInUser) {
        this.listOfProductsInUser = listOfProductsInUser;
    }
}
