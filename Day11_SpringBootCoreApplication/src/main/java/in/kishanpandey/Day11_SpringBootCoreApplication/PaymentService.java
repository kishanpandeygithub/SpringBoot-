package in.kishanpandey.Day11_SpringBootCoreApplication;

import org.springframework.stereotype.Component;

@Component
public class PaymentService {
    public void pay() {
        System.out.println("Payment done");
    }
}
