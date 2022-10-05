package by.sidina.it_shop.dto;

import by.sidina.it_shop.entity.product.Book;
import by.sidina.it_shop.entity.user.User;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ConverterFromDtoToEntity {
    public Book convertToBook(BookDto bookDto, Book book) {
        book.setName(bookDto.getName());
        book.setLanguage(bookDto.getLanguage());
        book.setAuthor(bookDto.getAuthor());
        BigDecimal price = new BigDecimal(bookDto.getPrice());
        book.setPrice(price);
        int pageNumber = Integer.parseInt(bookDto.getPageNumber());
        book.setPageNumber(pageNumber);
        int yearPublished = Integer.parseInt(bookDto.getYearPublished());
        book.setYearPublished(yearPublished);
        return book;
    }

    public User convertUser(UserDto userDto, User user) {
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setCountry(userDto.getCountry());
        return user;
    }
}
