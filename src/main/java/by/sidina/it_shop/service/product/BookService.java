package by.sidina.it_shop.service.product;

import by.sidina.it_shop.dao.product.BookBaseDAO;
import by.sidina.it_shop.model.product.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BookService implements BookBaseService<Book> {
    private final BookBaseDAO bookBaseDAO;

    @Autowired
    public BookService(@Qualifier("bookDAO") BookBaseDAO bookBaseDAO) {
        this.bookBaseDAO = bookBaseDAO;
    }

    @Override
    public List<Book> findAll() {
        return bookBaseDAO.findAll();
    }

    @Override
    public List<Book> findAll(int pageFirst, int pageSize) {
        return bookBaseDAO.findAll(pageFirst, pageSize);
    }

    @Override
    public BigInteger countPages(int pageFirst, int pageSize) {
        return bookBaseDAO.countPages(pageFirst, pageSize);
    }

    @Override
    public Optional<Book> findById(long id) {
        return bookBaseDAO.findById(id);
    }

    @Transactional
    @Override
    public void add(Book entity) {
        bookBaseDAO.addOrUpdate(entity);
    }

    @Override
    public List<Book> findAllByLanguage(String language) {
        return bookBaseDAO.findAllByLanguage(language);
    }

    @Override
    public List<Book> findAllByStatus(int statusId) {
        return bookBaseDAO.findAllByStatus(statusId);
    }
}
