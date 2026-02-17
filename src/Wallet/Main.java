package Wallet;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Wallet customWallet = new Wallet(new BigDecimal(100));

        customWallet.deposit(new BigDecimal(100));
        customWallet.withdraw(new BigDecimal(50));

        System.out.println(customWallet.getBalance());
        for (Transaction transaction : customWallet.getTransactionHistory()) {
            transaction.print();
        }
    }
}
