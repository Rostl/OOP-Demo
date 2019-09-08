package by.rost.jd01_15;

import by.rost.jd01_15.Util.RandomUtil;

import java.util.Deque;

public class Fabric implements Runnable {
    private final Deque<Robot.robotParts> dumpParts;
    private final int NIGHTS_QUANTITY = 100;
    private int firstNight = 1;
    private int partsQuantity;

    public Fabric(Deque<Robot.robotParts> madeParts) {
        this.dumpParts = madeParts;
    }

    @Override
    public void run() {
        synchronized (dumpParts) {
            Thread.currentThread().setName("Фабрика");
            RandomUtil.setTrigger(0, firstNight);
            for (int i = 1; i <= 20; i++) {
                dumpParts.add(Robot.getPartName(RandomUtil.generatePartIndex()));
            }
            System.out.println("Ночь " + firstNight++);
            System.out.println(Thread.currentThread().getName() + " выкинула на свалку " + dumpParts.size() + " частей роботов: " + dumpParts);
            System.out.println("На свалке " + dumpParts.size() + " деталей");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (firstNight <= NIGHTS_QUANTITY) {
            synchronized (dumpParts) {
                if (RandomUtil.checkTrigger(0, firstNight)) {
                    partsQuantity = RandomUtil.generateRandom();
                    for (int i = 1; i <= partsQuantity; i++) {
                        dumpParts.add(Robot.getPartName(RandomUtil.generatePartIndex()));
                    }
                    printPartsInfo();
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
    }

    private void printPartsInfo() {
        System.out.println();
        System.out.println("Ночь " + firstNight);
        System.out.println(Thread.currentThread().getName() + " выкинула на свалку " + partsQuantity + " частей роботов.");
        System.out.println("На свалке деталей: " + dumpParts.size() + " - " + dumpParts);
    }
}


