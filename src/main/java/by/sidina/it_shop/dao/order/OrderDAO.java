package by.sidina.it_shop.dao.order;

import by.sidina.it_shop.entity.order.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderDAO implements OrderBaseDAO<Order> {
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
    public Optional<Order> findById(long id) {
        Session session = sessionFactory.getCurrentSession();
        Order order = session.get(Order.class, id);
        return Optional.of(order);
    }

    @Override
    public void add(Order entity) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(entity);
    }

    @Override
    public void edit(Order entity) {
        Session session = sessionFactory.getCurrentSession();
        session.update(entity);
    }

    @Override
    public List<Order> findAllByUserId(long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Order WHERE user_id = :userId").setParameter("userId", id);
        List<Order> allOrders = query.getResultList();
        return allOrders;
    }
}
