package in.kishanPandey;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope("prototype")
public class CartService implements BeanNameAware, ApplicationContextAware  /*implements InitializingBean, DisposableBean*/ {
    Map<Integer, String> mp;

    public CartService() {
        this.mp = new HashMap<>();
        System.out.println("CartService Constructor called");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean name is " + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Application name is " + applicationContext);
    }
    //initilization using the @PostConstruct declear in the jakarta anotation library jar
    @PostConstruct
    public void start2() {
        System.out.println("Bean is ready");
        mp.put(1, "Kishan");
        mp.put(2, "Aditiya");
    }

    public void addToCart() {
        System.out.println("Added to cart");
    }

    public String getValue(int key) {
        return mp.get(key);
    }

    //using the predistroy
    @PreDestroy
    public void destroy() {
        mp.clear();
        System.out.println("Bean is Getting Distroyed");
    }


//    @Override
//    distroyin using the implemention of the disposable bean
//    public void destroy() throws Exception {
//        mp.clear();
//        System.out.println("Bean is Getting Distroyed");
//    }

    //distruction Bean
//    this is distroy method bean using the distroymehtod written in the AppConfing

//    public void stop(){
//        mp.clear();
//        System.out.println("Bean is Getting Distroyed");
//    }
//

//    this is initilization bean using the initmethod written in the AppConfing
//    public void start(){
//        System.out.println("Bean is ready");
//        mp.put(1 ,"Kishan");
//        mp.put(2 , "Aditiya");
//    }


    //this is the use of the initilizing bean interface to  initilize callback
//    @Override
////    public void afterPropertiesSet() throws Exception {
////        mp.put(1 ,"Kishan");
////        mp.put(2 , "Aditiya");
////    }
}
