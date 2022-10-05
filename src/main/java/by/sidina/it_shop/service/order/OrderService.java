package by.sidina.it_shop.service.order;

import by.sidina.it_shop.dao.order.OrderBaseDAO;
import by.sidina.it_shop.entity.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderService implements OrderBaseService<Order> {
    private final OrderBaseDAO orderBaseDAO;

    @Autowired
    public OrderService(@Qualifier("orderDAO") OrderBaseDAO orderBaseDAO) {
        this.orderBaseDAO = orderBaseDAO;
    }

    @Override
    public List<Order> findAll() {
        return orderBaseDAO.findAll();
    }

    @Override
    public Optional<Order> findById(long id) {
        return orderBaseDAO.findById(id);
    }

    @Override
    public void add(Order entity) {
        orderBaseDAO.add(entity);
    }

    @Override
    public void edit(Order entity) {
        orderBaseDAO.edit(entity);
    }

    @Override
    public List<Order> findAllByUserId(long id) {
        return orderBaseDAO.findAllByUserId(id);
    }
}