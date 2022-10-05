package by.sidina.it_shop.entity.order;

import by.sidina.it_shop.entity.EntityAbstract;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "order_status")
public class OrderStatus extends EntityAbstract {
    @Column(name = "status")
    private String orderStatus;

    public OrderStatus() {
    }

    public OrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
