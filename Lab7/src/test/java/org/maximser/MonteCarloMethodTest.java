package org.maximser;

import org.junit.jupiter.api.Test;

public class MonteCarloMethodTest {

    @Test
    public void testGetPiParallel() throws InterruptedException {
        long start, finish;
        start = System.currentTimeMillis();
        System.out.println("Parallel Pi is: " + new MonteCarloMethod().getPiParallel());
        finish = System.currentTimeMillis();
        System.out.println("ITERATIONS " + new MonteCarloMethod().getIterationsTotal());
        System.out.println("TIME " + (finish - start) + "ms");
        System.out.println("------------------------------");
    }

    @Test
    public void testGetPiMono() {
        long start = System.currentTimeMillis();
        System.out.println("Mono Pi: " + new MonteCarloMethod().getPi());
        long finish = System.currentTimeMillis();
        System.out.println("ITERATIONS " + new MonteCarloMethod().getIterationsTotal());
        System.out.println("TIME " + (finish - start) + "ms");
        System.out.println("-----------------------------------------------------------------");
    }
}



