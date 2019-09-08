package by.rost.jd01_15;

import by.rost.jd01_15.Util.RandomUtil;

import java.util.*;

public class Scientist implements Runnable {
    private final Deque<Robot.robotParts> dumpParts;
    private int id = 0;
    private final int NIGHTS_QUANTITY = 100;
    private int firstNight = 1;
    private int partsQuantity;
    private int robotsResault;

    public Scientist(Deque<Robot.robotParts> madeParts, int id) {
        this.dumpParts = madeParts;
        this.id = id;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("Прислужник " + id);
        Map<Robot.robotParts, Integer> warehouse = new HashMap<>();
        while (firstNight <= NIGHTS_QUANTITY) {
            synchronized (dumpParts) {
                if (RandomUtil.checkTrigger(id, firstNight)) {
                    if (!dumpParts.isEmpty()) {
                        partsQuantity = RandomUtil.generateRandom(dumpParts.size());
                        for (int i = 1; i <= partsQuantity; i++) {
                            Robot.robotParts onePart = dumpParts.getFirst();
                            putOnePart(warehouse, onePart);
                            dumpParts.removeFirst();
                        }
                        System.out.println(Thread.currentThread().getName() + " нашел деталей: " + partsQuantity);
                    } else {
                        System.out.println(Thread.currentThread().getName() + " ничего не нашел...");
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    firstNight--;
                }
            }

            firstNight++;
        }
        robotsResault = RandomUtil.preResault(warehouse);
        if (robotsResault == 0) {
            System.out.println("Нельзя собрать ниодного робота...");
        } else {
            RandomUtil.setPartsMin(Thread.currentThread().getName(), robotsResault);
        }
    }

    private void putOnePart(Map<Robot.robotParts, Integer> warehouse, Robot.robotParts onePart) {
        if (warehouse.containsKey(onePart)) {
            warehouse.put(onePart, warehouse.get(onePart) + 1);
        } else {
            warehouse.put(onePart, 1);
        }
    }
}

