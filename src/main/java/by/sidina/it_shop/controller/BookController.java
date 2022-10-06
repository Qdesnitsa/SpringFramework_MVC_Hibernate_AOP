package by.sidina.it_shop.controller;

import by.sidina.it_shop.dto.BookDto;
import by.sidina.it_shop.dto.ConverterFromDtoToEntity;
import by.sidina.it_shop.entity.product.Book;
import by.sidina.it_shop.entity.product.ProductStatus;
import by.sidina.it_shop.entity.user.User;
import by.sidina.it_shop.service.product.BookBaseService;
import by.sidina.it_shop.service.product.ProductStatusBaseService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/product")
public class BookController {
    private final BookBaseService bookBaseService;
    private final ProductStatusBaseService productStatusBaseService;
    private final ConverterFromDtoToEntity converter;

    public BookController(@Qualifier("bookService") BookBaseService bookBaseService,
                          @Qualifier("productStatusService") ProductStatusBaseService productStatusBaseService,
                          ConverterFromDtoToEntity converter) {
        this.bookBaseService = bookBaseService;
        this.productStatusBaseService = productStatusBaseService;
        this.converter = converter;
    }

    @GetMapping("/add-new-book")
    public String addNewBook(@ModelAttribute("newBook") BookDto book, Model model) {
        model.addAttribute("newBook", book);
        return "/product/add-new-book";
    }

    @PostMapping("/add-new-book")
    public String addNewBook(@Valid @ModelAttribute("newBook") BookDto book, BindingResult bindingResult, Model model,
                             HttpSession httpSession, @RequestParam("statusId") int id) {
        if (bindingResult.hasErrors()) {
            return "product/add-new-book";
        }
        Book bookEntity = null;
        ProductStatus productStatus = null;
        if (book.getId() == 0L) {
            bookEntity = converter.convertToBook(book, new Book());
            productStatus = (ProductStatus) productStatusBaseService.findById(1L).get();
            bookEntity.setProductStatus(productStatus);
        } else {
            bookEntity = converter.convertToBook(book, (Book) bookBaseService.findById(book.getId()).get());
            productStatus = (ProductStatus) productStatusBaseService.findById(id).get();
        }
        bookEntity.setUser((User) httpSession.getAttribute("currentUser"));
        bookEntity.setProductStatus(productStatus);
        bookBaseService.add(bookEntity);
        model.addAttribute("message", "Successfully.");
        return "product/add-new-book";
    }

    @GetMapping("/show-books")
    public String showBooks(Model model) {
        List<Book> books = bookBaseService.findAll();
        model.addAttribute("allBooks", books);
        return "product/show-all-books";
    }

    @RequestMapping("/editBook")
    public String editBook(@RequestParam("bookId") int id, Model model) {
        Book book = (Book) bookBaseService.findById(id).get();
        model.addAttribute("newBook", book);
        return "product/add-new-book";
    }

    @RequestMapping("/deleteBook")
    public String deleteBook(@RequestParam("bookId") int id) {
        Book book = (Book) bookBaseService.findById(id).get();
        ProductStatus productStatus = (ProductStatus) bookBaseService.findById(2L).get();
        book.setProductStatus(productStatus);
        return "product/show-all-books";
    }

    @RequestMapping("/addBookToShoppingCart")
    public String addBook(@RequestParam("bookId") int id, HttpSession httpSession, Model model) {
        Book book = (Book) bookBaseService.findById(id).get();
        User user = (User) httpSession.getAttribute("currentUser");
        if (book.getProductStatus().getId() != 2) {
            user.addProductToUser(book);
        } else {
            model.addAttribute("message", "Unfortunately book is currently unavailable");
        }
        List<Book> books = bookBaseService.findAll();
        model.addAttribute("allBooks", books);
        return "product/show-all-books";
    }
}
