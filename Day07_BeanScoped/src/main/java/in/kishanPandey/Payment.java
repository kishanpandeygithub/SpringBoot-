package in.kishanPandey;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Payment {
    public Payment() {
        System.out.println("Payment called");
    }

    public void pay(){
        System.out.println("Hello payment");
    }
}
