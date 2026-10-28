package in.kishanPandey.Day35_Transational_Propagation.repository;

import in.kishanPandey.Day35_Transational_Propagation.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order , Long> {

}
