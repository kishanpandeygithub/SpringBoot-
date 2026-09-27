package in.kishanpandey.Day12_SpringBootApplicationConfigaration;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoRunnner implements ApplicationRunner {
    private PaymentGateway paymentGateway;

    public DemoRunnner(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        paymentGateway.print();
    }
}

