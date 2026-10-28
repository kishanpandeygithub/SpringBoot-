package in.kishanPandey.Day34_Transation.service;


import in.kishanPandey.Day34_Transation.entity.Account;
import in.kishanPandey.Day34_Transation.entity.TransferRecord;
import in.kishanPandey.Day34_Transation.repository.AccountRepository;
import in.kishanPandey.Day34_Transation.repository.TransferRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class TransferService {
    private TransferRepository transferRepository;
    private AccountRepository accountRepository;

    public TransferService(TransferRepository transferRepository
            , AccountRepository accountRepository) {
        this.transferRepository = transferRepository;
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transfer(Long formAccountId ,
                         Long toAccountId,
                         BigDecimal amount){
         Account fromAccount = accountRepository.findById(formAccountId)
                 .orElseThrow(()->new RuntimeException("User not found"));
         Account toAccount = accountRepository.findById(toAccountId)
                 .orElseThrow(()->new RuntimeException("User not found"));
         fromAccount.debitAccount(amount);
         toAccount.craditAccount(amount);
         transferRepository.save(new TransferRecord(
                 formAccountId ,
                 toAccountId ,
                 amount ,
                 LocalDate.now()
         ));
         throw new RuntimeException("Some error occred");
    }
}
