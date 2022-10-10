package by.sidina.it_shop.service.user;

import by.sidina.it_shop.dao.user.UserStatusBaseDAO;
import by.sidina.it_shop.model.user.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
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

    @Transactional
    @Override
    public void add(UserStatus entity) {
        userStatusBaseDAO.addOrUpdate(entity);
    }
}
