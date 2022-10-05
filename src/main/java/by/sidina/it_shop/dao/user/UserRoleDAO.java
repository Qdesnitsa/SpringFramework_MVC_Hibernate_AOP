package by.sidina.it_shop.dao.user;

import by.sidina.it_shop.entity.user.UserRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRoleDAO implements UserRoleBaseDAO<UserRole> {
    private final SessionFactory sessionFactory;

    public UserRoleDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<UserRole> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List<UserRole> allUserRoles = session.createQuery("FROM UserRole", UserRole.class).getResultList();
        return allUserRoles;
    }

    @Override
    public Optional<UserRole> findById(long id) {
        Session session = sessionFactory.getCurrentSession();
        UserRole userRole = session.get(UserRole.class, id);
        return Optional.of(userRole);
    }

    @Override
    public void add(UserRole entity) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(entity);
    }

    @Override
    public void edit(UserRole entity) {
        Session session = sessionFactory.getCurrentSession();
        session.update(entity);
    }
}
