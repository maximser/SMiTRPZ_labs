package org.maximser;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestBank {
    static Bank bank;
    static int accountCount = (int) (Math.random() * 2500);
    int threadCount = (int) (Math.random() * 1000);
    int transactionCount = (int) (10e5 + ((int) Math.random() * 25e3));
    ExecutorService executorService = Executors.newFixedThreadPool(threadCount);

    @BeforeAll
    public static void setUp() throws Exception {
        bank = new Bank("BankOfAmerica");
        for (int i = 0; i < accountCount; i++) {
            bank.addAccount(new Account(Long.toHexString(Double.doubleToLongBits(Math.random())), bank.getLastId()));
            bank.getAccounts().stream().forEach(account -> account.deposit((int) (Math.random() * 1000)));
        }
        System.out.println("Total Bank balance before transactions " + bank.getTotalBalance() + " $");
    }


    private ArrayList<Future> refresh() {
        ArrayList<Future> futures = new ArrayList<>();
        for (int i = 0; i < transactionCount; i++) {
            int fromId = (int) (Math.random() * accountCount);
            int toIdTemp;
            while ((toIdTemp = (int) (Math.random() * accountCount)) == fromId) ;
            int toId = toIdTemp;
            futures.add(executorService.submit(() -> {
                bank.transfer(bank.getAccounts().get(fromId), bank.getAccounts().get(toId), (int) (Math.random() * 10e4));
            }));
        }
        return futures;
    }

    @Test
    public void testTotalBalanceEquals() throws InterruptedException, ExecutionException {
        for (int i = 0; i < 10; i++) {
            long previous = bank.getTotalBalance();
            for (Future future : refresh()) {
                future.get();
            }

        }
        System.out.println("Total Bank balance after  transactions " + bank.getTotalBalance() + " $");
    }
}
