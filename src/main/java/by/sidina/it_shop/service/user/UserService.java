package by.sidina.it_shop.service.user;

import by.sidina.it_shop.dao.exception.DAOException;
import by.sidina.it_shop.dao.user.UserBaseDAO;
import by.sidina.it_shop.dao.user.UserDAO;
import by.sidina.it_shop.entity.user.User;
import by.sidina.it_shop.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService implements UserBaseService<User> {
    private final UserBaseDAO userBaseDAO;

    @Autowired
    public UserService(@Qualifier("userDAO") UserBaseDAO userBaseDAO) {
        this.userBaseDAO = userBaseDAO;
    }

    @Override
    public List<User> findAll() {
        return userBaseDAO.findAll();
    }

    @Override
    public Optional<User> findById(long id) {
        return userBaseDAO.findById(id);
    }

    @Override
    public void add(User entity) {
        userBaseDAO.add(entity);
    }

    @Override
    public void edit(User entity) {
        userBaseDAO.edit(entity);
    }

    @Override
    public Optional<User> findByEmail(String email) throws ServiceException {
        try {
            return userBaseDAO.findByEmail(email);
        } catch (DAOException e) {
            throw new ServiceException("Failed attempt to find user in database", e);
        }
    }
}
