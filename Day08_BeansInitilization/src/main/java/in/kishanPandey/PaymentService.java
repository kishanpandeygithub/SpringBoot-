package in.kishanPandey;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Lazy
//@Scope("prototype")
public class PaymentService {
    private OrderService orderService;
    public PaymentService(OrderService orderService){
        this.orderService  = orderService;
    }
    public void pay(){
        System.out.println("Payment Done");
        orderService.getDetails();
    }
}
