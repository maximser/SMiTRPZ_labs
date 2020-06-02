package org.maximser;

import java.util.ArrayList;


public class Bank {
    private String name;
    private ArrayList<Account> accounts = new ArrayList<>();

    public Bank(String name) {
        this.name = name;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void transfer(Account from, Account to, int amount) {
        synchronized (from) {
            synchronized (to) {
                if (from.withdraw(amount))
                    to.deposit(amount);
            }
        }
    }

    public long getTotalBalance() {
        long bankBalance = 0;
        for (Account account : accounts)
            bankBalance += account.getBalance();
        return bankBalance;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public String getName() {
        return name;
    }

}
