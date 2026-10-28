package in.kishanPandey.Day34_Transation.service;

import in.kishanPandey.Day34_Transation.entity.Account;
import in.kishanPandey.Day34_Transation.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createAccount(Account account){
        accountRepository.save(account);
    }
}
