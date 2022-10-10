package by.sidina.it_shop.service.user;

import by.sidina.it_shop.service.BaseService;
import by.sidina.it_shop.service.exception.ServiceException;

import java.util.Optional;

public interface UserBaseService<T> extends BaseService<T> {
    Optional<T> findByEmail(String email) throws ServiceException;
}
