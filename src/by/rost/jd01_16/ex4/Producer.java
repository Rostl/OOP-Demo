package by.rost.jd01_16.ex4;

import lombok.AllArgsConstructor;

import java.util.Deque;

import static by.itacademy.lesson15.ex4.RandomUtil.generateDefault;

@AllArgsConstructor
public class Producer implements Runnable {

    private static final int MAX_COUNT = 10;
    private final Deque<Integer> deque;

    @Override
    public void run() {
        synchronized (deque) {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " пытается положить в очередь...");
                if (deque.size() < MAX_COUNT) {
                    int generatedValue = generateDefault();
                    deque.add(generatedValue);
                    System.out.println(Thread.currentThread().getName() + " произвел число " + generatedValue);
                    System.out.println("Количество элементов в очереди: " + deque.size());
                }
                try {
                    System.out.println(Thread.currentThread().getName() + " заснул");
                    deque.wait(10L);
                    System.out.println(Thread.currentThread().getName() + " проснулся");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
