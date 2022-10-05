package by.sidina.it_shop.service.product;

import by.sidina.it_shop.dao.product.BookBaseDAO;
import by.sidina.it_shop.dao.product.BookDAO;
import by.sidina.it_shop.entity.product.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
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
    public Optional<Book> findById(long id) {
        return bookBaseDAO.findById(id);
    }

    @Override
    public void add(Book entity) {
        bookBaseDAO.add(entity);
    }

    @Override
    public void edit(Book entity) {
        bookBaseDAO.edit(entity);
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
