package by.rost.jd01_17.ex1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorDemo {

    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(() -> counter++);
        executorService.execute(new Decrement());

        executorService.shutdown();
        executorService.awaitTermination(2L, TimeUnit.MILLISECONDS);
        System.out.println("OK");
    }

    private static class Increment implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 100000; i++) {
                System.out.println(++counter);
            }
        }
    }

    private static class Decrement implements Runnable {

        @Override
        public void run() {

            for (int i = 0; i < 100000; i++) {
                System.out.println(--counter);
            }
        }
    }
}
