package by.sidina.it_shop.dao.product;

import by.sidina.it_shop.model.product.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public class BookDAO implements BookBaseDAO<Book, Long> {
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
    public List<Book> findAll(int pageFirst, int pageSize) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Book", Book.class);
        query.setFirstResult(pageFirst);
        query.setMaxResults(pageSize);
        List<Book> allBooks = query.getResultList();
        return allBooks;
    }

    @Override
    public BigInteger countPages(int pageFirst, int pageSize) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery("SELECT count(products.id) FROM products");
        BigInteger countResults = (BigInteger) query.uniqueResult();
        BigInteger lastPageNumber = countResults.divide(BigInteger.valueOf(pageSize));
        //int lastPageNumber = (int) (Math.ceil(countResults / filter.getPageSize()));
        return lastPageNumber;
    }

    @Override
    public Optional<Book> findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = session.get(Book.class, id);
        return Optional.of(book);
    }

    @Override
    public void addOrUpdate(Book entity) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(entity);
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
