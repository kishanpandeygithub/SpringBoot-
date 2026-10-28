package in.kishanPandey.Day34_Transation.repository;

import in.kishanPandey.Day34_Transation.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account , Long> {

}
