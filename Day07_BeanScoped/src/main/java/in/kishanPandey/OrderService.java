package in.kishanPandey;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
//@Scope("singleton")
public class OrderService {
    public OrderService() {
        System.out.println("Order Services Created");
    }

    public void placeOrder() {
        System.out.println("Order Placed");
    }
}
