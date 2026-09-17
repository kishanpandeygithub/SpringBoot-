package in.kishanPandey;

import in.kishanPandey.Payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//note: if the class has only one dependeny you not need the writhe the autowaired

//@Component
public class OrderService {
   // Field injection means that the instancde variabe is already injected
//    @Autowired
    private  PaymentService paymentService ;


    //most recomendaded
//    /dependency injection throught  the constructuo
    @Autowired //: it say the paymentservice dependency of the orderservice is injected through the constructor
    public  OrderService(@Qualifier("up") PaymentService paymentService){
        this.paymentService = paymentService;
    }

//    dependency injection throught  the setter
//    @Autowired
//    public void setPaymentService(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }

    public void placeOrder(){
        paymentService.pay();
        System.out.println("Order palced");
    }
}
