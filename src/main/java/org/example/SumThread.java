package org.example;

public class SumThread extends Thread{
    private final int id;
    private final int step;
    private final BreakThread breakThread;

    public SumThread(int id, int step, BreakThread breakThread) {
        this.id = id;
        this.step = step;
        this.breakThread = breakThread;
    }

    @Override
    public void run() {
        long sum = 0;
        long current = 0;
        long count = 0;
        boolean isStop = false;

        do{
            sum += current;
            current += step;
            count++;
            isStop = breakThread.isCanBreak(id);
        } while (!isStop);

        System.out.println((id+1) + " - " + sum+ " - " + count);
    }
}