package in.kishanPandey;

import in.kishanPandey.Payment.CardPayment;
import in.kishanPandey.Payment.PaymentService;
import in.kishanPandey.Payment.UpiPayment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.net.PasswordAuthentication;

@Configuration //this say it is the configaration class and
@ComponentScan("in.kishanPandey") //this say that in the in.kishapandey you have to manage all the componet class
public class AppConfig {
    //empty
    @Bean
    public User createUser(){
        return new User("Kishan", 21);
    }

    @Bean
    public CartService createCartService(){
        return new CartService();
    }

    @Bean
    @Qualifier("cp")
    public PaymentService CreateCardPayment (){
        return new CardPayment();
    }
    @Bean
//    @Primary
    @Qualifier("up")
    public PaymentService CreateOrderService (){
        return new UpiPayment();
    }

    @Bean
    public OrderService createOrderService( PaymentService paymentService){
        return new OrderService(paymentService);
    }
}
