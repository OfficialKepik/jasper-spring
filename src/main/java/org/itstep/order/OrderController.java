package org.itstep.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/order", produces = "application/json")
    public List<Order> getOrders() {
        return orderService.findAll();
    }

    @GetMapping(value = "/orders/sort", produces = "application/json")
    public List<Order> getOrdersSort(@RequestParam(name = "property") String property) {
        return orderService.orderBy(property);
    }
}
