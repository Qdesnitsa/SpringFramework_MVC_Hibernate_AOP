package by.sidina.it_shop.entity.order;

import by.sidina.it_shop.entity.EntityAbstract;
import by.sidina.it_shop.entity.product.ProductAbstract;
import by.sidina.it_shop.entity.user.User;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Component
@Entity
@Table(name = "order")
public class Order extends EntityAbstract {
    @Column(name = "date_order")
    private Date dateOfOrder;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, optional = false)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, optional = false)
    @JoinColumn(name = "order_status_id")
    private OrderStatus orderStatus;
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.EAGER)
    @JoinTable(name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<ProductAbstract> listOfProductsInOrder;

    public Order() {
    }

    public Order(Date dateOfOrder, User user, OrderStatus orderStatus) {
        this.dateOfOrder = dateOfOrder;
        this.user = user;
        this.orderStatus = orderStatus;
    }

    public void addProductToOrder(ProductAbstract product) {
        if (listOfProductsInOrder == null) {
            listOfProductsInOrder = new ArrayList<>();
        }
        listOfProductsInOrder.add(product);
    }

    public void removeProductFromOrder(ProductAbstract product) {
        listOfProductsInOrder.remove(product);
    }

    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<ProductAbstract> getListOfProductsInOrder() {
        return listOfProductsInOrder;
    }

    public void setListOfProductsInOrder(List<ProductAbstract> listOfProductsInOrder) {
        this.listOfProductsInOrder = listOfProductsInOrder;
    }
}
