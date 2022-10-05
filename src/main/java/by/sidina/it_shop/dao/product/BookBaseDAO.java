package by.sidina.it_shop.dao.product;

import by.sidina.it_shop.dao.BaseDAO;

import java.util.List;

public interface BookBaseDAO<T> extends BaseDAO<T> {
    List<T> findAllByLanguage(String language);

    List<T> findAllByStatus(int statusId);
}
