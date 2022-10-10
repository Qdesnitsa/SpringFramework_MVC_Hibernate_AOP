package by.sidina.it_shop.service.product;

import by.sidina.it_shop.model.product.Book;
import by.sidina.it_shop.service.BaseService;

import java.math.BigInteger;
import java.util.List;

public interface BookBaseService<T> extends BaseService<T> {
    List<T> findAllByLanguage(String language);

    List<T> findAllByStatus(int statusId);
    List<Book> findAll(int pageFirst, int pageSize);
    BigInteger countPages(int pageFirst, int pageSize);
}
