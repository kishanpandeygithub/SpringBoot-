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
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TransferRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long fromAccountId;

    private Long toAccountId;

    private BigDecimal ammount;

    private LocalDate transferedAt;

    public TransferRecord(Long fromAccountId, Long toAccountId,
                          BigDecimal ammount, LocalDate transferedAt) {
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.ammount = ammount;
        this.transferedAt = transferedAt;
    }
}
