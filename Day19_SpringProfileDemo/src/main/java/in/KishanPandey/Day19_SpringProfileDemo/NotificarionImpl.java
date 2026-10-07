package in.KishanPandey.Day19_SpringProfileDemo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class NotificarionImpl implements NotificationService{
    @Override
    public String send() {
        return "Here is a Real notification";
    }
}
