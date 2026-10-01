package in.kishanPandey;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
//@Scope("prototype")
public class OrderService {
    private Payment payment;

    public OrderService(Payment payment) {
        this.payment =payment;
        System.out.println("Order Services Created");
    }

    public void placeOrder() {
        System.out.println("Order Placed");
    }
}
