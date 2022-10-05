package by.sidina.it_shop.service;

import by.sidina.it_shop.entity.EntityAbstract;

import java.util.List;
import java.util.Optional;

public interface BaseService<T> {
    List<T> findAll();

    Optional<T> findById(long id);

    void add(T entity);

    void edit(T entity);
}
