package in.kishanPandey.Day14_BankAccountCrudOperation.Service;

import in.kishanPandey.Day14_BankAccountCrudOperation.Controller.BankAccountController;
import in.kishanPandey.Day14_BankAccountCrudOperation.Entity.BankAccount;
import in.kishanPandey.Day14_BankAccountCrudOperation.Repository.BankAccountRepostory;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankAccountService {
    private BankAccountRepostory bankAccountRepostory;

    @Autowired
    public BankAccountService(BankAccountRepostory bankAccountRepostory) {
        this.bankAccountRepostory = bankAccountRepostory;
    }

    //creating the bank accoutn
    public BankAccount createAccount(BankAccount bankAccount) {
        BankAccount newBankAccount = bankAccountRepostory.save(bankAccount);
        return newBankAccount;
    }

    //geting all the bank account
    public List<BankAccount> getAllBackAccount() {
        List<BankAccount> bankAccounts = bankAccountRepostory.findAll();
        return bankAccounts;
    }

    //getting the Bankaccoutn through the id
    public BankAccount getBackAccount(Long id) {
        Optional<BankAccount> bankAccount = bankAccountRepostory.findById(id);
        if (bankAccount.isPresent()) {
            return bankAccount.get();
        }
        return null;
    }

    //update the bank accoutn
    public BankAccount updateAccountInfo(Long id, BankAccount newAccoutnInfo) {
        Optional<BankAccount> privBankAccount = bankAccountRepostory.findById(id);
        if (privBankAccount.isEmpty()) {
            return null;
        }
        BankAccount bankAccount = privBankAccount.get();
        bankAccount.setAccountNumber(newAccoutnInfo.getAccountNumber());
        bankAccount.setAccountType(newAccoutnInfo.getAccountType());
        bankAccount.setActive(newAccoutnInfo.getActive());
        bankAccount.setHolderName(newAccoutnInfo.getHolderName());
        bankAccount.setEmail(newAccoutnInfo.getEmail());
        bankAccount.setBranchName(newAccoutnInfo.getBranchName());
        bankAccount.setPhoneNo(newAccoutnInfo.getPhoneNo());

        BankAccount updatedAccount = bankAccountRepostory.save(bankAccount);
        return updatedAccount;
    }


    //delete the account
    public Boolean deleteAccount(Long id) {
        Boolean isexist = bankAccountRepostory.existsById(id);
        if (!isexist) {
            return false;
        }
        bankAccountRepostory.deleteById(id);
        return true;
    }

    //deposit money
    public BankAccount deposit(Long id, Double amount) {
        Optional<BankAccount> bankAccount = bankAccountRepostory.findById(id);
        if (bankAccount.isEmpty()) {
            return null;
        }
        BankAccount userAccount = bankAccount.get();
        Double currentBalance = userAccount.getBalance();
        currentBalance += amount;
        userAccount.setBalance(currentBalance);
        return bankAccountRepostory.save(userAccount);
    }

    //withDrawAmmount
    public BankAccount withDrawAmount(Long id, Double amount) {
        Optional<BankAccount> bankAccount = bankAccountRepostory.findByIdAndActiveIsTrue(id);
        if (bankAccount.isEmpty()) {
            return null;
        }
        BankAccount userAccount = bankAccount.get();
        double currBalance = userAccount.getBalance();
        if (currBalance >= amount) {
            currBalance -= amount;
            userAccount.setBalance(currBalance);
            bankAccountRepostory.save(userAccount);
        } else {
            return null;
        }
        return userAccount;
    }

    //activate the account
    public BankAccount ActivateAccount(Long id) {
        Optional<BankAccount> account = bankAccountRepostory.findByIdAndActiveIsFalse(id);
        if (account.isEmpty()) {
            return null;
        }
        BankAccount userAccount = account.get();
        userAccount.setActive(true);
        return bankAccountRepostory.save(userAccount);
    }

    //deActivate Account
    public BankAccount deactivateAccount(Long id) {
        Optional<BankAccount> account = bankAccountRepostory.findByIdAndActiveIsTrue(id);
        if (account.isEmpty()) {
            return null;
        }
        BankAccount userAccount = account.get();
        userAccount.setActive(false);
        return bankAccountRepostory.save(userAccount);
    }

    public Boolean transferMoneyFromAccount(Long id1, Long id2 , int amount) {
        Optional<BankAccount> accountFrom = bankAccountRepostory.findByIdAndActiveIsTrue(id1);
        if (accountFrom.isEmpty()) {
            return false;
        }
        Optional<BankAccount> accountTo = bankAccountRepostory.findByIdAndActiveIsTrue(id2);
        if (accountTo.isEmpty()) {
            return false;
        }
        BankAccount fromAccount = accountFrom.get();
        BankAccount toAccount = accountTo.get();
        if(fromAccount.getBalance()>=amount){
            fromAccount.setBalance(fromAccount.getBalance()-amount);
            bankAccountRepostory.save(fromAccount);
            toAccount.setBalance(toAccount.getBalance()+amount);
            bankAccountRepostory.save(toAccount);
            return true;
        }
        else {
            return false;
        }
    }
}
