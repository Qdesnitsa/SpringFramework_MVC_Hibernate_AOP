package by.sidina.it_shop.dao.user;

import by.sidina.it_shop.entity.user.UserStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserStatusDAO implements UserStatusBaseDAO<UserStatus> {
    private final SessionFactory sessionFactory;

    public UserStatusDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<UserStatus> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List<UserStatus> allUserStatuses = session.createQuery("FROM UserStatus", UserStatus.class).getResultList();
        return allUserStatuses;
    }

    @Override
    public Optional<UserStatus> findById(long id) {
        Session session = sessionFactory.getCurrentSession();
        UserStatus userStatus = session.get(UserStatus.class, id);
        return Optional.of(userStatus);
    }

    @Override
    public void add(UserStatus entity) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(entity);
    }

    @Override
    public void edit(UserStatus entity) {
        Session session = sessionFactory.getCurrentSession();
        session.update(entity);
    }
}
