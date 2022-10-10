package by.sidina.it_shop.service.order;

import by.sidina.it_shop.dao.order.OrderStatusBaseDAO;
import by.sidina.it_shop.model.order.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class OrderStatusService implements OrderStatusBaseService<OrderStatus> {
    private final OrderStatusBaseDAO orderStatusBaseDAO;

    @Autowired
    public OrderStatusService(@Qualifier("orderStatusDAO") OrderStatusBaseDAO orderStatusBaseDAO) {
        this.orderStatusBaseDAO = orderStatusBaseDAO;
    }

    @Override
    public List<OrderStatus> findAll() {
        return orderStatusBaseDAO.findAll();
    }

    @Override
    public Optional<OrderStatus> findById(long id) {
        return orderStatusBaseDAO.findById(id);
    }

    @Transactional
    @Override
    public void add(OrderStatus entity) {
        orderStatusBaseDAO.addOrUpdate(entity);
    }
}
