package in.kishanPandey;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class B {
    private A a;

    public void setA(A a) {
        System.out.println("Dependesy injected");
        this.a = a;
    }
}
