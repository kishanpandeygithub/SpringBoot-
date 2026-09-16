package in.kishanPandey.Notification;

import java.awt.desktop.SystemEventListener;

public class FakeEmailServices implements NotificationService{
    @Override
    public  void SendNotification(){
        System.out.println("Dummy Email Send");
    }
}
