package by.sidina.it_shop.controller;

import by.sidina.it_shop.model.order.Order;
import by.sidina.it_shop.model.order.OrderStatus;
import by.sidina.it_shop.model.product.AbstractProduct;
import by.sidina.it_shop.model.user.User;
import by.sidina.it_shop.service.order.OrderBaseService;
import by.sidina.it_shop.service.order.OrderStatusBaseService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<AbstractProduct> listUserProduct = user.getListOfProductsInUser();
        BigDecimal amountPayable = BigDecimal.ZERO;
        if (listUserProduct != null) {
            amountPayable = listUserProduct.stream()
                    .map(product -> product.getPrice())
                    .reduce(BigDecimal::add).get();
        }
        model.addAttribute("myList", listUserProduct);
        model.addAttribute("amountToPay", amountPayable);
        return "/order/show-my-shopping-cart";
    }

    @RequestMapping("/deleteProduct")
    public String deleteBook(@RequestParam("productId") int id, Model model, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("currentUser");
        AbstractProduct product = user.getListOfProductsInUser().stream().filter(p -> (p.getId() == id)).findFirst().get();
        user.getListOfProductsInUser().remove(product);
        List<AbstractProduct> list = user.getListOfProductsInUser();
        BigDecimal amountPayable = list.stream()
                .map(prod -> prod.getPrice())
                .reduce(BigDecimal::add).get();
        model.addAttribute("myList", list);
        model.addAttribute("amountToPay", amountPayable);
        return "/order/show-my-shopping-cart";
    }

    @RequestMapping("/buyNow")
    public String buyNow(HttpSession httpSession, Model model) {
        User user = (User) httpSession.getAttribute("currentUser");
        Timestamp currentDate = Timestamp.valueOf(LocalDateTime.now());
        OrderStatus orderStatus = (OrderStatus) orderStatusBaseService.findById(2L).get();
        Order order = new Order(currentDate, user, orderStatus);
        user.getListOfProductsInUser().stream().forEach(product -> order.addProductToOrder(product));
        orderBaseService.add(order);
        user.getListOfProductsInUser().clear();
        model.addAttribute("message", "Successfully.");
        return "/order/show-my-shopping-cart";
    }

    @GetMapping("/show-my-shopping-history")
    public String showHistory(HttpSession httpSession, Model model) {
        User user = (User) httpSession.getAttribute("currentUser");
        List<Order> orders = orderBaseService.findAllByUserId(user.getId());
//        List<ProductAbstract> products = orders.stream()
//                .flatMap(order -> order.getListOfProductsInOrder().stream())
//                .collect(Collectors.toList()).stream().collect(Collectors.toList());
        HashMap<Timestamp, List<AbstractProduct>> smallMap = new HashMap<>();
        Map<Long, HashMap<Timestamp, List<AbstractProduct>>> superMap = new HashMap<>();
        for (Order ord : orders) {
            smallMap.put(ord.getDateOfOrder(), ord.getListOfProductsInOrder());
            superMap.put(ord.getId(), new HashMap<>(smallMap));
            smallMap.clear();
        }
        model.addAttribute("map", superMap);
        return "/order/show-my-shopping-history";
    }
}
