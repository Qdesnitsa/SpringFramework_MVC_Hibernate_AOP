package by.sidina.it_shop.dao;

import java.util.List;
import java.util.Optional;

public interface BaseDAO<T, ID> {
    List<T> findAll();

    Optional<T> findById(ID id);

    void addOrUpdate(T entity);
}
