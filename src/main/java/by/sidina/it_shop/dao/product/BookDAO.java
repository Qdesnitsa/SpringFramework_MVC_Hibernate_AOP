package by.sidina.it_shop.dao.product;

import by.sidina.it_shop.entity.product.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookDAO implements BookBaseDAO<Book> {
    private final SessionFactory sessionFactory;

    public BookDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Book> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Book> allBooks = session.createQuery("FROM Book", Book.class).getResultList();
        return allBooks;
    }

    @Override
    public Optional<Book> findById(long id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = session.get(Book.class, id);
        return Optional.of(book);
    }

    @Override
    public void add(Book entity) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(entity);
    }

    @Override
    public void edit(Book entity) {
        Session session = sessionFactory.getCurrentSession();
        session.update(entity);
    }

    @Override
    public List<Book> findAllByLanguage(String language) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Book WHERE progr_language = :language").setParameter("language", language);
        List<Book> allBooks = query.getResultList();
        return allBooks;
    }

    @Override
    public List<Book> findAllByStatus(int statusId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Book WHERE product_status_id = :bookStatusId").setParameter("bookStatusId", statusId);
        List<Book> allBooks = query.getResultList();
        return allBooks;
    }
}
