package by.sidina.it_shop.controller;

import by.sidina.it_shop.entity.order.Order;
import by.sidina.it_shop.entity.order.OrderStatus;
import by.sidina.it_shop.entity.product.ProductAbstract;
import by.sidina.it_shop.entity.user.User;
import by.sidina.it_shop.service.order.OrderBaseService;
import by.sidina.it_shop.service.order.OrderStatusBaseService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    private final OrderStatusBaseService orderStatusBaseService;
    private final OrderBaseService orderBaseService;

    public OrderController(@Qualifier("orderStatusService") OrderStatusBaseService orderStatusBaseService,
                           @Qualifier("orderService") OrderBaseService orderBaseService) {
        this.orderStatusBaseService = orderStatusBaseService;
        this.orderBaseService = orderBaseService;
    }

    @GetMapping("/show-my-shopping-cart")
    public String addNewBook(HttpSession httpSession, Model model) {
        User user = (User) httpSession.getAttribute("currentUser");
        List<ProductAbstract> listUserProduct = user.getListOfProductsInUser();
        model.addAttribute("myList", listUserProduct);
        return "/order/show-my-shopping-cart";
    }

    @RequestMapping("/deleteProduct")
    public String deleteBook(@RequestParam("productId") int id, Model model, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("currentUser");
        ProductAbstract product = user.getListOfProductsInUser().stream().filter(p -> (p.getId() == id)).findFirst().get();
        user.getListOfProductsInUser().remove(product);
        List<ProductAbstract> list = user.getListOfProductsInUser();
        model.addAttribute("myList", list);
        return "/order/show-my-shopping-cart";
    }

    @RequestMapping("/buyNow")
    public String buyNow(HttpSession httpSession, Model model) {
        User user = (User) httpSession.getAttribute("currentUser");
        Date currentDate = Date.valueOf(LocalDate.now());
        OrderStatus orderStatus = (OrderStatus) orderStatusBaseService.findById(2L).get();
        Order order = new Order(currentDate, user, orderStatus);
        for (ProductAbstract prod : user.getListOfProductsInUser()) {
            order.addProductToOrder(prod);
        }
        orderBaseService.add(order);
        model.addAttribute("message", "Successfully.");
        return "/order/show-my-shopping-cart";
    }

    @GetMapping("/show-my-shopping-history")
    public String showHistory(HttpSession httpSession, Model model) {
        User user = (User) httpSession.getAttribute("currentUser");
        List<Order> orders = orderBaseService.findAllByUserId(user.getId());
        List<ProductAbstract> products = new ArrayList<>();
        for (Order order : orders) {
            for (ProductAbstract prod : order.getListOfProductsInOrder()) {
                products.add(prod);
            }
        }
        model.addAttribute("myList", products);
        return "/order/show-my-shopping-history";
    }
}
