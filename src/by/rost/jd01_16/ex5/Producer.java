package by.rost.jd01_16.ex5;

import by.itacademy.lesson15.ex4.RandomUtil;

import java.util.concurrent.BlockingDeque;

public class Producer implements Runnable {

    private final BlockingDeque<Integer> deque;

    public Producer(BlockingDeque<Integer> deque) {
        this.deque = deque;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int generatedValue = RandomUtil.generateDefault();
                System.out.println(Thread.currentThread().getName() + " произвел число " + generatedValue);
                deque.put(generatedValue);
                System.out.println(Thread.currentThread().getName() + " положил " + generatedValue);
                System.out.println("Количество элементов: " + deque.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
