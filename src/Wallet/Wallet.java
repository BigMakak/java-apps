package Wallet;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class Wallet {
    private final AtomicReference<BigDecimal> balance;
    private final List<Transaction> transactions = new CopyOnWriteArrayList<>();

    public Wallet(BigDecimal initialBalance) {
        this.balance = new AtomicReference<>(initialBalance);
    }

    public BigDecimal getBalance() {
        return this.balance.get();
    }

    public void deposit(BigDecimal amount) {
        validateAmount(amount);

        BigDecimal newBalance = this.balance.updateAndGet(currentBalance -> currentBalance.add(amount));
        this.transactions.add(new Transaction(amount,TransactionType.DEPOSIT,LocalDateTime.now(),newBalance));
    }

    public BigDecimal withdraw(BigDecimal amount) {
        validateAmount(amount);

        BigDecimal newBalance = this.balance.updateAndGet(currentBalance -> {
            if (currentBalance.compareTo(amount) < 0) {
                throw new IllegalStateException("Insufficient funds");
            }
            return currentBalance.subtract(amount);
        });

        this.transactions.add(new Transaction(amount, TransactionType.WITHDRAWAL, LocalDateTime.now(), newBalance));
        return amount;
    }

    public List<Transaction> getTransactionHistory() {
        return Collections.unmodifiableList(this.transactions);
    }

    private void validateAmount(BigDecimal amount) throws IllegalAmountException {
        if(amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalAmountException("Amount cannot be null or negative");
        }
    }
}

