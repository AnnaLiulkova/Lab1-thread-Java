package org.example;

public class BreakThread implements Runnable{

    private volatile boolean[] canBreak;
    private final long[] stopTimes;

    public BreakThread(int threadsCount) {
        this.canBreak = new boolean[threadsCount];
        this.stopTimes = new long[threadsCount];

        System.out.println("Generated time for threads:");

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < threadsCount; i++) {
            long delaySeconds = 2 + (long)(Math.random() * 7);
            this.stopTimes[i] = startTime + (delaySeconds * 1000);
            System.out.println((i + 1) + " thread - " + delaySeconds + " seconds");
        }
        System.out.println("---");
    }

    @Override
    public void run() {
        int stoppedCount = 0;

        while (stoppedCount < canBreak.length) {
            long currentTime = System.currentTimeMillis();

            for (int i = 0; i < canBreak.length; i++) {
                if (!canBreak[i] && currentTime >= stopTimes[i]) {
                    canBreak[i] = true;
                    stoppedCount++;
                }
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    boolean isCanBreak(int id) {
        return canBreak[id];
    }
}