package org.maximser;

public class Account {
    private int balance;
    private String name;
    private final int id;


    public Account(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public boolean deposit(int amount) {
        balance += amount;
        return true;
    }

    public boolean withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public int getBalance() {
        return balance;
    }


    public int getId() {
        return id;
    }
}

