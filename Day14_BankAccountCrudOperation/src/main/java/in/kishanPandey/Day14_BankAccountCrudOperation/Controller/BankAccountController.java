package in.kishanPandey.Day14_BankAccountCrudOperation.Controller;

import in.kishanPandey.Day14_BankAccountCrudOperation.Entity.BankAccount;
import in.kishanPandey.Day14_BankAccountCrudOperation.Service.BankAccountService;
import jakarta.persistence.criteria.Predicate;
import org.hibernate.annotations.Audited;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class BankAccountController {
    private BankAccountService bankAccountService;

    @Autowired
    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    //createing the new back Account
    @PostMapping("/create")
    public ResponseEntity<BankAccount> createAccount(@RequestBody BankAccount bankAccount) {
        BankAccount bankAccount1 = bankAccountService.createAccount(bankAccount);
        return ResponseEntity.status(HttpStatus.OK).body(bankAccount1);
    }

//   GET     {`/api/accounts` }   Get all bank accounts

    @GetMapping("/get")
    public ResponseEntity<List<BankAccount>> getAllAccount() {
        List<BankAccount> bankAccounts = bankAccountService.getAllBackAccount();
        if (bankAccounts.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(bankAccounts);
    }

    //  GET    `{/api/accounts/{id}` }   Get account by ID
    @GetMapping("/getById")
    public ResponseEntity<BankAccount> getAccount(@RequestParam Long id) {
        BankAccount bankAccount = bankAccountService.getBackAccount(id);
        if (bankAccount == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(bankAccount);
    }

//   PUT    { `/api/accounts/{id}`}  Update complete account

    @PutMapping("update")
    public ResponseEntity<BankAccount> updateAccount(@RequestParam Long id, @RequestBody BankAccount newAccoutnInfo) {
        BankAccount updatedBackAccount = bankAccountService.updateAccountInfo(id, newAccoutnInfo);
        if (updatedBackAccount == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(updatedBackAccount);
    }

    //  DELETE  { `/api/accounts/{id}`}  Delete account
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAccount(@RequestParam Long id) {
        Boolean isDeleted = bankAccountService.deleteAccount(id);
        if (isDeleted == false) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body("Record deleted Successfully");
    }


    //Deposit and Withdraw
//    PATCH  | {`/api/accounts/{id}/deposit/{amount}`}  | Deposit money
    @PatchMapping("/{id}/deposit/{amount}")
    public ResponseEntity<BankAccount> deposit(@PathVariable Long id, @PathVariable Double amount) {
        BankAccount bankAccount = bankAccountService.deposit(id, amount);
        if (bankAccount == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(bankAccount);
    }


    //    PATCH  | `/api/accounts/{id}/withdraw/{amount}` | Withdraw money
    @PatchMapping("/{id}/withdraw/{amount}")
    public ResponseEntity<BankAccount> withDraw(@PathVariable Long id, @PathVariable Double amount) {
        BankAccount bankAccount = bankAccountService.withDrawAmount(id, amount);
        if (bankAccount == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(bankAccount);
    }

//    | PATCH  | {`/api/accounts/{id}/activate`}          | Activate account

    @PatchMapping("/{id}/activate")
    public ResponseEntity<String> Activate(@PathVariable Long id) {
        BankAccount bankAccount = bankAccountService.ActivateAccount(id);
        if (bankAccount == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account Cant Be Acctivated");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Account Activated");
    }


    //     PATCH  | `/api/accounts/{id}/deactivate`        | Deactivate account
    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<String> deactivate(@PathVariable Long id) {
        BankAccount bankAccount = bankAccountService.deactivateAccount(id);
        if (bankAccount == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account Cant Be Deactivated");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Account DeActivated");
    }

    //PATCH / '/api/accounts/from/{id}/to/{id}.
    @PatchMapping("/from/{id1}/to/{id2}/{amount}")
    public ResponseEntity<String> transferMoney(@PathVariable Long id1 , @PathVariable Long id2 ,@PathVariable Integer amount){
        Boolean isSuccessfull = bankAccountService.transferMoneyFromAccount(id1 ,id2 , amount);
        if(isSuccessfull){
            return ResponseEntity.status(200).body("Successfull Transfer amount");
        }
        return ResponseEntity.status(400).build();
    }
}
