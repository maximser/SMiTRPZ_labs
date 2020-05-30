package org.maximser;

import java.util.Random;

public class MonteCarloMethod {
    private static final long ITERATIONS = (long) 10e9;

    public static long getIterationsTotal() {
        return ITERATIONS;
    }

    public double getPi() {
        double x, y;
        double radius = 1.0;
        long passed = 0;
        Random rnd = new Random();
        for (int i = 0; i < ITERATIONS; ++i) {
            x = rnd.nextDouble();
            y = rnd.nextDouble();
            if ((x * x + y * y) < radius)
                passed++;
            if (i % (int)10e4 == 0) System.out.format("PI=%f",((double) passed / ITERATIONS) * 4.0);
        }
        return ((double) passed / ITERATIONS) * 4.0;

    }

    public double getPiParallel() throws InterruptedException {
        int n = Runtime.getRuntime().availableProcessors();
        long passedTotal = 0, iterationsPerProcess = ITERATIONS / n;
        PiCalculationThread[] piCalculationThreads = new PiCalculationThread[n];
        for (int i = 0; i < n; i++) {
            piCalculationThreads[i] = new PiCalculationThread(iterationsPerProcess);
            piCalculationThreads[i].start();
        }
        for (PiCalculationThread piCalculationThread : piCalculationThreads) {
            piCalculationThread.join();
            passedTotal += piCalculationThread.passed;
        }
        return ((double) passedTotal / ITERATIONS) * 4.0;

    }
}
