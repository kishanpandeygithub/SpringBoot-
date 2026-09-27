package in.kishanPandey;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        //get bean by id
//        OrderService order  = (OrderService) context.getBean("orderService");
        //get bean by class
//        OrderService order2 = context.getBean(OrderService.class);
        //both use
//        OrderService order = context.getBean( "orderService",OrderService.class);
////        PaymentService payment = context.getBean( "paymentService",PaymentService.class);
//        order.placeOrder();
//        payment.pay();
//        order2.placeOrder();

        UserService user = context.getBean(UserService.class);

        context.close();
    }
}