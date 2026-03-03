package org.example;

public class BreakThread implements Runnable{

    private boolean[] canBreak;

    public BreakThread(int threadsCount) {
        this.canBreak = new boolean[threadsCount];
    }

    @Override
    public void run() {
        for (int i = 0; i < canBreak.length; i++) {
            try {
                long delay = 2000 + (long)(Math.random() * 2001);
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            canBreak[i] = true;
        }
    }

    synchronized boolean isCanBreak(int id) {
        return canBreak[id];
    }
}