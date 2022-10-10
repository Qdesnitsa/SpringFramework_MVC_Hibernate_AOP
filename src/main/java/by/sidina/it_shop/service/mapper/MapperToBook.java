package by.sidina.it_shop.service.mapper;

import by.sidina.it_shop.dto.BookDto;
import by.sidina.it_shop.model.product.Book;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class MapperToBook {
    public Book mapToBook(BookDto bookDto, Book book) {
        book.setName(bookDto.getName());
        book.setLanguage(bookDto.getLanguage());
        book.setAuthor(bookDto.getAuthor());
        BigDecimal price = new BigDecimal(bookDto.getPrice().replace(',','.'))
                .setScale(2, RoundingMode.DOWN);
        book.setPrice(price);
        int pageNumber = Integer.parseInt(bookDto.getPageNumber());
        book.setPageNumber(pageNumber);
        int yearPublished = Integer.parseInt(bookDto.getYearPublished());
        book.setYearPublished(yearPublished);
        return book;
    }
}
