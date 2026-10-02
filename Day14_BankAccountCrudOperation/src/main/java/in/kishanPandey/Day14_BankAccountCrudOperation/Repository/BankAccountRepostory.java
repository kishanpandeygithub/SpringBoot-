package in.kishanPandey.Day14_BankAccountCrudOperation.Repository;

import in.kishanPandey.Day14_BankAccountCrudOperation.Entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankAccountRepostory extends JpaRepository<BankAccount , Long> {
    Optional<BankAccount> findByIdAndActiveIsTrue(Long id);
    Optional<BankAccount> findByIdAndActiveIsFalse(Long id);
}
