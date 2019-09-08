package by.rost.jd01_16.ex3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Queue2Demo {

    public static void test() {
        List<Integer> integers = new ArrayList<>();
        Class<Queue2Demo> queue2DemoClass = Queue2Demo.class;
        synchronized (Queue2Demo.class) {
            integers.add(1);
        }
    }

    public static void main(String[] args) {
        test();
        Queue<Object> cashDesks = new LinkedList<>();
        cashDesks.add(new Object());
        cashDesks.add(new Object());

        List<BuyerThread> buyerThreads = Arrays.asList(
                new BuyerThread(cashDesks),
                new BuyerThread(cashDesks),
                new BuyerThread(cashDesks),
                new BuyerThread(cashDesks),
                new BuyerThread(cashDesks),
                new BuyerThread(cashDesks),
                new BuyerThread(cashDesks),
                new BuyerThread(cashDesks),
                new BuyerThread(cashDesks),
                new BuyerThread(cashDesks)
        );
        BuyerThread buyerThread1 = buyerThreads.get(0);
        Class<? extends BuyerThread> aClass = buyerThread1.getClass();
        Class<BuyerThread> buyerThreadClass = BuyerThread.class;
        System.out.println(aClass == buyerThreadClass);

        buyerThreads.forEach(Thread::start);

        for (BuyerThread buyerThread : buyerThreads) {
            try {
                buyerThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
