package by.sidina.it_shop.dao;

import java.util.List;
import java.util.Optional;

public interface BaseDAO<T> {
    List<T> findAll();

    Optional<T> findById(long id);

    void add(T entity);

    void edit(T entity);
}
