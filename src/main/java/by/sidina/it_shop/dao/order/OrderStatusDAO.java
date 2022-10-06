package by.sidina.it_shop.dao.order;

import by.sidina.it_shop.entity.order.OrderStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderStatusDAO implements OrderStatusBaseDAO<OrderStatus, Long> {
    private final SessionFactory sessionFactory;

    public OrderStatusDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<OrderStatus> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List<OrderStatus> allOrderStatuses = session.createQuery("FROM OrderStatus", OrderStatus.class).getResultList();
        return allOrderStatuses;
    }

    @Override
    public Optional<OrderStatus> findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        OrderStatus orderStatus = session.get(OrderStatus.class, id);
        return Optional.of(orderStatus);
    }

    @Override
    public void addOrUpdate(OrderStatus entity) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(entity);
    }
}
