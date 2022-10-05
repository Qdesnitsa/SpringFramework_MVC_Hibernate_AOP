package by.sidina.it_shop.service.product;

import by.sidina.it_shop.entity.product.ProductAbstract;
import by.sidina.it_shop.service.BaseService;

import java.util.List;

public interface VideoBaseService<T> extends BaseService<T> {
    List<T> findAllByLanguage(String language);

    List<T> findAllByStatus(int statusId);
}
