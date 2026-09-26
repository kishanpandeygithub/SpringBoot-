package in.kishanPandey;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component("userBean")
public class UserService implements BeanNameAware {

    public UserService() {
        System.out.println("User Construction called");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean Name is " + name);
    }
}
