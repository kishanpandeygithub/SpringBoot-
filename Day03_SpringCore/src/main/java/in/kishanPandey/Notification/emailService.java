package in.kishanPandey.Notification;

public class emailService implements NotificationService {
    @Override
    public void SendNotification(){
        System.out.println("Email notification Send");
    }
}
