package in.kishanPandey;

import in.kishanPandey.Notification.*;

import java.util.EmptyStackException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        NotificationService notification = new emailService();
//        OrderService order =new OrderService(notification);
//        order.placeOrder();
        OrderService order  = new OrderService();
        order.setNotification(notification);
        System.out.println("Hello World");
    }
}

//A class should ask it need and not build everything it needs
//dependency injection
//type of dependency injection


//IOC :Inversion of control