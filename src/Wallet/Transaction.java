package Wallet;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Transaction(BigDecimal amount, TransactionType type, LocalDateTime date, BigDecimal balance) {
    public void print() {
        System.out.printf("%s || %s || %s || %s \r\n", amount, type, date, balance);
    }
}
