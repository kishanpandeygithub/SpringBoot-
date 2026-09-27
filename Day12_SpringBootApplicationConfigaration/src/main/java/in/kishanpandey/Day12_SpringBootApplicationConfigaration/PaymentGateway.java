package in.kishanpandey.Day12_SpringBootApplicationConfigaration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.PublicKey;

@Component
public class PaymentGateway {

    private PaymentPropertyes paymentPropertyes;

    public PaymentGateway(PaymentPropertyes paymentPropertyes) {
        this.paymentPropertyes = paymentPropertyes;
    }

    public String getType() {
        return paymentPropertyes.getType();
    }

    public int getRetryCount() {
        return paymentPropertyes.getRetryCount();
    }

    public Boolean getEnabled() {
        return paymentPropertyes.getEnabled();
    }

    public int getTimeOut() {
        return paymentPropertyes.getTimeOut();
    }

    public void print(){
        System.out.println(getTimeOut());
        System.out.println(getType());
        System.out.println(getRetryCount());
        System.out.println(getEnabled());
    }


    //    @Value("${paymentGateway.type:Razarpay}")
//    private String type;
//    @Value("${paymentGateway.retryCount:3}")
//    private int retryCount;

//    public PaymentGateway(String type ,
//                          int retryCount) {
//        this.type = type;
//        this.retryCount =retryCount;
//    }
    //    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public int getRetryCount() {
//        return retryCount;
//    }
//
//    public void setRetryCount(int retryCount) {
//        this.retryCount = retryCount;
//    }
}


//@Value