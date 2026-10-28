package in.kishanPandey.Day34_Transation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.security.PrivateKey;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal balance;

    public Account(String name, BigDecimal balance) {
        this.name = name;
        this.balance = balance;
    }

    public void debitAccount(BigDecimal amount){
        if(amount==null|| amount.signum()<=0){
            throw  new IllegalArgumentException("Amount must be positive");
        }
        if(balance.compareTo(amount)<0){
            throw  new RuntimeException("Insufficient Exception");
        }
        this.balance = this.balance.subtract(amount);
    }
    public void craditAccount(BigDecimal amount){
        if(amount==null|| amount.signum()<=0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        this.balance = this.balance.add(amount);
    }
}
