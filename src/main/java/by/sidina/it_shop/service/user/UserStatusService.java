package by.sidina.it_shop.service.user;

import by.sidina.it_shop.dao.user.UserStatusBaseDAO;
import by.sidina.it_shop.dao.user.UserStatusDAO;
import by.sidina.it_shop.entity.user.UserStatus;
import by.sidina.it_shop.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserStatusService implements UserStatusBaseService<UserStatus> {
    private final UserStatusBaseDAO userStatusBaseDAO;

    @Autowired
    public UserStatusService(@Qualifier("userStatusDAO") UserStatusBaseDAO userStatusBaseDAO) {
        this.userStatusBaseDAO = userStatusBaseDAO;
    }

    @Override
    public List<UserStatus> findAll() {
        return userStatusBaseDAO.findAll();
    }

    @Override
    public Optional<UserStatus> findById(long id) {
        return userStatusBaseDAO.findById(id);
    }

    @Override
    public void add(UserStatus entity) {
        userStatusBaseDAO.add(entity);
    }

    @Override
    public void edit(UserStatus entity) {
        userStatusBaseDAO.edit(entity);
    }
}
