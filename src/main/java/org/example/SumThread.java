package org.example;
import java.math.BigInteger;

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
        BigInteger sum = BigInteger.ZERO;
        BigInteger current = BigInteger.ZERO;

        BigInteger stepBig = BigInteger.valueOf(step);
        long count = 0;
        boolean isStop = false;

        do{
            sum = sum.add(current);
            current = current.add(stepBig);
            count++;
            isStop = breakThread.isCanBreak(id);
        } while (!isStop);

        System.out.println((id+1) + " - " + sum+ " - " + count);
    }
}