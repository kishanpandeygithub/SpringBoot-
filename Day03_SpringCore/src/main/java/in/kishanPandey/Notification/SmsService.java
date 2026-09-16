package in.kishanPandey.Notification;

public class SmsService implements NotificationService {
    @Override
    public void SendNotification(){
        System.out.println("SMS notification send");
    }
}
