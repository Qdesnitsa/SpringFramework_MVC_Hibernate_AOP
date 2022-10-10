package by.sidina.it_shop.model.order;

import by.sidina.it_shop.model.AbstractEntity;
import by.sidina.it_shop.model.product.AbstractProduct;
import by.sidina.it_shop.model.user.User;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order extends AbstractEntity {
    @Column(name = "date", updatable = false)
    private Timestamp dateOfOrder;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, optional = false)
    @JoinColumn(name = "user_id", updatable = false)
    private User user;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, optional = false)
    @JoinColumn(name = "order_status_id", updatable = false)
    private OrderStatus orderStatus;
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.EAGER)
    @JoinTable(name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<AbstractProduct> listOfProductsInOrder;

    public Order() {
    }

    public Order(Timestamp dateOfOrder, User user, OrderStatus orderStatus) {
        this.dateOfOrder = dateOfOrder;
        this.user = user;
        this.orderStatus = orderStatus;
    }

    public void addProductToOrder(AbstractProduct product) {
        if (listOfProductsInOrder == null) {
            listOfProductsInOrder = new ArrayList<>();
        }
        listOfProductsInOrder.add(product);
    }

    public void removeProductFromOrder(AbstractProduct product) {
        listOfProductsInOrder.remove(product);
    }

    public Timestamp getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Timestamp dateOfOrder) {
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

    public List<AbstractProduct> getListOfProductsInOrder() {
        return listOfProductsInOrder;
    }

    public void setListOfProductsInOrder(List<AbstractProduct> listOfProductsInOrder) {
        this.listOfProductsInOrder = listOfProductsInOrder;
    }
}
