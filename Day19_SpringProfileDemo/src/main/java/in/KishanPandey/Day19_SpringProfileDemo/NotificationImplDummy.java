package in.KishanPandey.Day19_SpringProfileDemo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"dev" ,"default" , "staging"})
public class NotificationImplDummy implements NotificationService{

    @Override
    public String send() {
        return "Here is the Dummy notification";
    }
}
