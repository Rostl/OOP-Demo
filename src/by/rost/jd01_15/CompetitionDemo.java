package by.rost.jd01_15;

import by.rost.jd01_15.Util.RandomUtil;

import java.util.Deque;
import java.util.LinkedList;

public class CompetitionDemo {
    public static void main(String[] args) {

        Deque<Robot.robotParts> dump = new LinkedList<>();
        Thread fabric = new Thread(new Fabric(dump));
        Thread scientist1 = new Thread(new Scientist(dump, 1));
        Thread scintist2 = new Thread(new Scientist(dump, 2));

        fabric.start();
        scientist1.start();
        scintist2.start();
        try {
            fabric.join();
            scientist1.join();
            scintist2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RandomUtil.whosWin();
    }
}
