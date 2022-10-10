package by.sidina.it_shop.dao.product;

import by.sidina.it_shop.dao.BaseDAO;
import by.sidina.it_shop.model.product.Book;

import java.math.BigInteger;
import java.util.List;

public interface BookBaseDAO<T, ID> extends BaseDAO<T, ID> {
    BigInteger countPages(int pageFirst, int pageSize);

    List<T> findAllByLanguage(String language);

    List<T> findAllByStatus(int statusId);
    List<Book> findAll(int pageFirst, int pageSize);
}
