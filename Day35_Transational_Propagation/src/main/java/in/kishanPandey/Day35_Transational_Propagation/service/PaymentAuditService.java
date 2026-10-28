package in.kishanPandey.Day35_Transational_Propagation.service;

import in.kishanPandey.Day35_Transational_Propagation.entity.Order;
import in.kishanPandey.Day35_Transational_Propagation.entity.PaymentAudit;
import in.kishanPandey.Day35_Transational_Propagation.repository.PaymentAuditRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentAuditService {
    private PaymentAuditRepository paymentAuditRepository;

    public PaymentAuditService(PaymentAuditRepository paymentAuditRepository) {
        this.paymentAuditRepository = paymentAuditRepository;
    }

    @Transactional(
            propagation = Propagation.REQUIRED ,
            isolation = Isolation.DEFAULT
    )
    public void audit(Order order){
        PaymentAudit paymentAudit = new PaymentAudit(order.getAmount() , order.getId() , true);
        paymentAuditRepository.save(paymentAudit);
//        try {
//            throw new RuntimeException("Some error Occred");
//        }
//        catch (RuntimeException e){}

//        throw new RuntimeException("Some error Occred");
    }
}
