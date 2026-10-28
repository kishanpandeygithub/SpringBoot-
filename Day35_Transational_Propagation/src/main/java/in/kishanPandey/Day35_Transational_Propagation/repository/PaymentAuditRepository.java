package in.kishanPandey.Day35_Transational_Propagation.repository;

import in.kishanPandey.Day35_Transational_Propagation.entity.PaymentAudit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentAuditRepository extends JpaRepository<PaymentAudit ,Long> {
}
