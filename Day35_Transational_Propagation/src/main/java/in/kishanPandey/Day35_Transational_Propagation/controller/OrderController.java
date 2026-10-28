package in.kishanPandey.Day35_Transational_Propagation.controller;

import in.kishanPandey.Day35_Transational_Propagation.entity.Order;
import in.kishanPandey.Day35_Transational_Propagation.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<String> placeOrder(
            @RequestBody Order order
            ){
        orderService.placeOrder(order);
        return ResponseEntity.ok("Done");
    }
}
