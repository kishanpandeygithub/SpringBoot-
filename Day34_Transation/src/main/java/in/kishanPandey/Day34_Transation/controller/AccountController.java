package in.kishanPandey.Day34_Transation.controller;

import in.kishanPandey.Day34_Transation.entity.Account;
import in.kishanPandey.Day34_Transation.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<String> createAccount(@RequestBody Account account){
        accountService.createAccount(account);
        return ResponseEntity.ok("Done");
    }

}
