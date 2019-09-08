package by.rost.jd01_17.ex1;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableDemo {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return getRandom();
            }
        });
        System.out.println("Иду выполнять дальше");
        executorService.shutdown();
        executorService.awaitTermination(1L, TimeUnit.HOURS);
        System.out.println("Жду результат...");
        System.out.println(future.get());
    }

    public static Integer getRandom() throws InterruptedException {
        Thread.sleep(6000L);
        return RANDOM.nextInt(100);
    }
}
