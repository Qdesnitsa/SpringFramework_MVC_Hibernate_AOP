package by.sidina.it_shop.dao.order;

import by.sidina.it_shop.dao.BaseDAO;

import java.util.List;

public interface OrderBaseDAO<T, ID> extends BaseDAO<T, ID> {
    List<T> findAllByUserId(ID id);
}
