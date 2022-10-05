package by.sidina.it_shop.dao.user;

import by.sidina.it_shop.dao.exception.DAOException;
import by.sidina.it_shop.entity.user.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDAO implements UserBaseDAO<User> {
    private final SessionFactory sessionFactory;

    public UserDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List<User> allUsers = session.createQuery("FROM User", User.class).getResultList();
        return allUsers;
    }

    @Override
    public Optional<User> findById(long id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        return Optional.of(user);
    }

    @Override
    public void add(User entity) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(entity);
    }

    @Override
    public void edit(User entity) {
        Session session = sessionFactory.getCurrentSession();
        session.update(entity);
    }

    @Override
    public Optional<User> findByEmail(String email) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM User WHERE email = :email").setParameter("email", email);
        User user = null;
        try {
            user = (User) query.getSingleResult();
        } catch (NoResultException e) {
            throw new DAOException("Attempt to find user in database", e);
        }
        return Optional.of(user);
    }
}
