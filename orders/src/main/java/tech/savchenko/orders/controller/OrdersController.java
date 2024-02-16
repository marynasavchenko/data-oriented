package tech.savchenko.orders.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    private final OrderProcessor orderProcessor;

    @Autowired
    public OrdersController(OrderProcessor orderProcessor) {
        this.orderProcessor = orderProcessor;
    }

    @PostMapping
    public ResponseEntity<String> processOrder(@RequestBody Order order) {
        orderProcessor.processOrder(order);
        return ResponseEntity.ok("Order processed successfully! " + order);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrders() {
        return ResponseEntity.ok(orderProcessor.getAllOrders());
    }
}
