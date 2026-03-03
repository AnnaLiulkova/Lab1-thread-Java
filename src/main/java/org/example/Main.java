package org.example;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of threads: ");
        int threadsCount = in.nextInt();
        in.close();

        BreakThread breakThread = new BreakThread(threadsCount);

        for (int i = 0; i < threadsCount; i++) {
            int step = (i + 1) * 2;
            new SumThread(i, step, breakThread).start();
        }

        new Thread(breakThread).start();
    }
}
