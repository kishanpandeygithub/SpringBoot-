package in.kishanPandey;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.security.PublicKey;

@Component
//@Lazy
//@Scope("prototype")
public class OrderService {
    PaymentService paymentService;

    public OrderService(@Lazy PaymentService paymentService){
        this.paymentService = paymentService;
    }
    public void placeOrder(){
        paymentService.pay();
        System.out.println("Order Placed");
    }
    public void getDetails(){
        System.out.println("Order Details");
    }
}
