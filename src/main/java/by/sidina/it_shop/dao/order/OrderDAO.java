package by.sidina.it_shop.dao.order;

import by.sidina.it_shop.model.order.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderDAO implements OrderBaseDAO<Order, Long> {
    private final SessionFactory sessionFactory;

    public OrderDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Order> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Order> allOrders = session.createQuery("FROM Order", Order.class).getResultList();
        return allOrders;
    }

    @Override
    public Optional<Order> findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Order order = session.get(Order.class, id);
        return Optional.of(order);
    }

    @Override
    public void addOrUpdate(Order entity) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(entity);
    }

    @Override
    public List<Order> findAllByUserId(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Order WHERE user_id = :userId").setParameter("userId", id);
        List<Order> allOrders = query.getResultList();
        return allOrders;
    }
}
