package by.sidina.it_shop.controller;

import by.sidina.it_shop.dto.BookDto;
import by.sidina.it_shop.service.mapper.MapperToBook;
import by.sidina.it_shop.model.product.Book;
import by.sidina.it_shop.model.product.ProductStatus;
import by.sidina.it_shop.model.user.User;
import by.sidina.it_shop.service.product.BookBaseService;
import by.sidina.it_shop.service.product.ProductStatusBaseService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.math.BigInteger;
import java.util.List;

@Controller
@RequestMapping("/product")
public class BookController {
    private final BookBaseService bookBaseService;
    private final ProductStatusBaseService productStatusBaseService;
    private final MapperToBook converter;

    public BookController(@Qualifier("bookService") BookBaseService bookBaseService,
                          @Qualifier("productStatusService") ProductStatusBaseService productStatusBaseService,
                          MapperToBook converter) {
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
            bookEntity = converter.mapToBook(book, new Book());
            productStatus = (ProductStatus) productStatusBaseService.findById(1L).get();
            bookEntity.setProductStatus(productStatus);
        } else {
            bookEntity = converter.mapToBook(book, (Book) bookBaseService.findById(book.getId()).get());
            productStatus = (ProductStatus) productStatusBaseService.findById(id).get();
        }
        bookEntity.setUser((User) httpSession.getAttribute("currentUser"));
        bookEntity.setProductStatus(productStatus);
        bookBaseService.add(bookEntity);
        model.addAttribute("message", "Successfully.");
        return "product/add-new-book";
    }

    @GetMapping("/show-books")
    public String showBooks(@RequestParam int page, @RequestParam int pageSize, Model model) {
        List<Book> books = bookBaseService.findAll(page, pageSize);
        BigInteger countPages = bookBaseService.countPages(page, pageSize);
        model.addAttribute("allBooks", books);
        model.addAttribute("countPages", countPages);
        return "product/show-all-books";
    }

    @RequestMapping("/editBook/{bookId}")
    public String editBook(@PathVariable(name = "bookId") int id, Model model) {
        Book book = (Book) bookBaseService.findById(id).get();
        model.addAttribute("newBook", book);
        List<Book> books = bookBaseService.findAll();
        model.addAttribute("allBooks", books);
        return "product/add-new-book";
    }

    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable(name = "bookId") int id, Model model) {
        Book book = (Book) bookBaseService.findById(id).get();
        ProductStatus productStatus = (ProductStatus) productStatusBaseService.findById(2L).get();
        book.setProductStatus(productStatus);
        bookBaseService.add(book);
        List<Book> books = bookBaseService.findAll();
        model.addAttribute("allBooks", books);
        return "product/show-all-books";
    }

    @RequestMapping("/addBookToShoppingCart/{bookId}")
    public String addBook(@PathVariable(name = "bookId") int id, HttpSession httpSession, Model model) {
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
