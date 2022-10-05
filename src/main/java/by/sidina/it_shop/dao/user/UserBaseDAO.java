package by.sidina.it_shop.dao.user;

import by.sidina.it_shop.dao.BaseDAO;
import by.sidina.it_shop.dao.exception.DAOException;

import java.util.Optional;

public interface UserBaseDAO<T> extends BaseDAO<T> {
    Optional<T> findByEmail(String email) throws DAOException;
}
