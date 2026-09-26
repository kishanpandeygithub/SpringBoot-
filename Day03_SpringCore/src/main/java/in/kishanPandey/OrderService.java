package in.kishanPandey;

import in.kishanPandey.Notification.NotificationService;
import in.kishanPandey.Notification.PopUpService;
import in.kishanPandey.Notification.SmsService;
import in.kishanPandey.Notification.emailService;

public class OrderService {
    NotificationService notification ;
//    public OrderService(NotificationService notification){
//        this.notification = notification;
//    }
    public OrderService(){

    }
    public void placeOrder(){
        System.out.println("Order Placed");
        notification.SendNotification();
    }

    public void setNotification(NotificationService notification) {
        this.notification = notification;
    }
}
