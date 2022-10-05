package by.sidina.it_shop.entity.user;

import by.sidina.it_shop.entity.EntityAbstract;
import by.sidina.it_shop.entity.product.Book;
import by.sidina.it_shop.entity.product.ProductAbstract;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User extends EntityAbstract {
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "country")
    private String country;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, optional = false)
    @JoinColumn(name = "user_role_id")
    private UserRole userRole;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, optional = false)
    @JoinColumn(name = "user_status_id")
    private UserStatus userStatus;
    @Transient
    private List<ProductAbstract> listOfProductsInUser;

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

    public void addProductToUser(ProductAbstract product) {
        if (listOfProductsInUser == null) {
            listOfProductsInUser = new ArrayList<>();
        }
        listOfProductsInUser.add(product);
    }

    public void removeProductFromOrder(ProductAbstract product) {
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

    public List<ProductAbstract> getListOfProductsInUser() {
        return listOfProductsInUser;
    }

    public void setListOfProductsInUser(List<ProductAbstract> listOfProductsInUser) {
        this.listOfProductsInUser = listOfProductsInUser;
    }
}
