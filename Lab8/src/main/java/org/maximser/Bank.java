package org.maximser;

import java.util.ArrayList;


public class Bank {
    private String name;
    private ArrayList<Account> accounts = new ArrayList<>();
    private int lastId;

    public Bank(String name) {
        this.name = name;
        lastId = 0;
    }

    public void addAccount(Account account) {
        accounts.add(account);
        lastId++;
    }

    public void transfer(Account from, Account to, int amount) {
        if (from.getId() > from.getId()) {
            synchronized (to) {
                synchronized (from) {
                    if (from.withdraw(amount))
                        to.deposit(amount);
                }
            }
        } else {
            synchronized (from) {
                synchronized (to) {
                    if (from.withdraw(amount))
                        to.deposit(amount);
                }
            }
        }
    }

    public long getTotalBalance() {
        long ans = 0;
        for (Account account : accounts)
            ans += account.getBalance();
        return ans;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public String getName() {
        return name;
    }

    public int getLastId() {
        return lastId;
    }

}