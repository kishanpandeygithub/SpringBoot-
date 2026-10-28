package in.kishanPandey.Day35_Transational_Propagation.service;

import in.kishanPandey.Day35_Transational_Propagation.entity.Order;
import in.kishanPandey.Day35_Transational_Propagation.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private PaymentAuditService paymentAuditService;

    public OrderService(OrderRepository orderRepository , PaymentAuditService paymentAuditService) {
        this.orderRepository = orderRepository;
        this.paymentAuditService = paymentAuditService;
    }

//    @Transactional
    public void placeOrder(Order order){
        orderRepository.save(order);
//        try {
            paymentAuditService.audit(order);
//        }
//        catch (RuntimeException e){}

//        throw new RuntimeException("Some error Occred");
    }
}
