package by.sidina.it_shop.model.product;

import by.sidina.it_shop.model.AbstractEntity;
import by.sidina.it_shop.model.order.Order;
import by.sidina.it_shop.model.user.User;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "products")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "product_type_id", discriminatorType = DiscriminatorType.INTEGER)
public abstract class AbstractProduct extends AbstractEntity {

    private String name;
    @Column(name = "progr_language")
    private String language;

    private String author;

    private BigDecimal price;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, optional = false)
    @JoinColumn(name = "product_status_id")
    private ProductStatus productStatus;
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "order_product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    private List<Order> orders;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    public AbstractProduct() {
    }

    public AbstractProduct(String name, String language, String author, BigDecimal price, ProductStatus productStatus, User user) {
        this.name = name;
        this.language = language;
        this.author = author;
        this.price = price;
        this.productStatus = productStatus;
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ProductStatus getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(ProductStatus productStatus) {
        this.productStatus = productStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", productStatus=" + productStatus +
                ", user=" + user;
    }
}
