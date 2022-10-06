package by.sidina.it_shop.service.user;

import by.sidina.it_shop.dao.user.UserRoleBaseDAO;
import by.sidina.it_shop.entity.user.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserRoleService implements UserRoleBaseService<UserRole> {
    private final UserRoleBaseDAO userRoleBaseDAO;

    @Autowired
    public UserRoleService(@Qualifier("userRoleDAO") UserRoleBaseDAO userRoleBaseDAO) {
        this.userRoleBaseDAO = userRoleBaseDAO;
    }

    @Override
    public List<UserRole> findAll() {
        return userRoleBaseDAO.findAll();
    }

    @Override
    public Optional<UserRole> findById(long id) {
        return userRoleBaseDAO.findById(id);
    }

    @Override
    public void add(UserRole entity) {
        userRoleBaseDAO.addOrUpdate(entity);
    }
}
