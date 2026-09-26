package in.kishanPandey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.PublicKey;

@Component
public class PaymentService {
    @Autowired
    OrderService orderService;

//    @Autowired
//    public PaymentService(OrderService orderService){
//        this.orderService = orderService;
//    }
    public void pay(){
        System.out.println("Payment done");
        orderService.getOrderDetails();
    }
}
