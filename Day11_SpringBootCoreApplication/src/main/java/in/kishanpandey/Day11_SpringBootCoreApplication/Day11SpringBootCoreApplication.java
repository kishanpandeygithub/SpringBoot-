package in.kishanpandey.Day11_SpringBootCoreApplication;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Day11SpringBootCoreApplication {
    public static void main(String[] args) {
        ApplicationContext contex =
        SpringApplication.run(Day11SpringBootCoreApplication.class, args);
        OrderService order =  contex.getBean(OrderService.class);
        order.placeOrder();
    }
    @Bean
    public UserService getUser(){
        return new UserService();
    }
}
