package by.sidina.it_shop.dao.order;

import by.sidina.it_shop.dao.BaseDAO;

import java.util.List;

public interface OrderBaseDAO<T> extends BaseDAO<T> {
    List<T> findAllByUserId(long id);
}
