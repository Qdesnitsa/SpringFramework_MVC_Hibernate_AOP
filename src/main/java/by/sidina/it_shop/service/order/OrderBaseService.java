package by.sidina.it_shop.service.order;

import by.sidina.it_shop.service.BaseService;

import java.util.List;

public interface OrderBaseService<T> extends BaseService<T> {
    List<T> findAllByUserId(long id);
}
