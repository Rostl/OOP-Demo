package by.rost.jd01_15.Util;

import by.rost.jd01_15.Robot;

import java.util.*;

public class RandomUtil {
    private RandomUtil() {
    }

    private static final Random RANDOM = new Random();
    private static final int PART_INDEX = 9;
    private static int min = 1;
    private static int max = 4;
    private static int[] arrTrigger = {0, 0, 0};
    private static Map<String, Integer> partsMin = new HashMap();

    /*
     * генерирует детль робота для фабрики
     * */
    public static int generatePartIndex() {
        return RANDOM.nextInt(PART_INDEX);
    }

    /*
     * устанавливает флаг на новую ночь
     * */
    public static void setTrigger(int trigger, int night) {
        arrTrigger[trigger] = night;
    }

    /*
     * проверяет состояние флага для перехода на новую ночь
     * */
    public static boolean checkTrigger(int trigger, int night) {
        boolean res = false;
        if (trigger == 0) {
            if (arrTrigger[1] == arrTrigger[2] && night - 1 == arrTrigger[1]) {
                arrTrigger[trigger] = night;
                res = true;
            }
        } else {
            if (night == arrTrigger[0]) {
                arrTrigger[trigger] = night;
                res = true;
            }
        }
        return res;
    }

    /*
     * генерирует кличество деталей (от 1 -до 4)
     * */
    public static int generateRandom() {
        return min + RANDOM.nextInt(max - min);
    }

    /*
     * генерирует кличество деталей (от 1 -до 4)
     * */
    public static int generateRandom(int madePartsSize) {
        int rand;

        if (madePartsSize < 4) {
            rand = RANDOM.nextInt(madePartsSize) + min;
        } else {
            rand = RANDOM.nextInt(max - min) + min;
        }
        return rand;
    }

    /*
     * помещает количество деталей робота и прислужника в коллекцию
     * */
    public static void setPartsMin(String name, Integer robotsCount) {
        RandomUtil.partsMin.put(name, robotsCount);
    }

    /*
     * проверяет минимальное количество деталей для сборки робота
     * */
    public static int preResault(Map<Robot.robotParts, Integer> warehouse) {
        System.out.println();
        System.out.println(Thread.currentThread().getName() + " собрал детали: " + warehouse);
        System.out.println();
        int count = 0;
        int minValue = 0;
        for (Map.Entry<Robot.robotParts, Integer> item : warehouse.entrySet()) {
            count++;
        }
        if (count == 9) {
            System.out.println(Thread.currentThread().getName() + " говорит, все элементы на месте, можно собирать...");
            for (Map.Entry<Robot.robotParts, Integer> min : warehouse.entrySet()) {
                if (minValue == 0) {
                    minValue = min.getValue();
                } else if (minValue > min.getValue()) {
                    minValue = min.getValue();
                }
            }
            System.out.println(Thread.currentThread().getName() + " собрал  " + minValue + " роботов");
        } else {
            System.out.println("Похоже деталей не хватает, подумал " + Thread.currentThread().getName());
            minValue = 0;
        }
        return minValue;
    }

    /*
     * выбирает победителя (по значениям из коллекции)
     * */
    public static void whosWin() {
        int maxValue = 0;
        String maxPerson = "";
        boolean deadHeat = false;
        for (Map.Entry<String, Integer> max : partsMin.entrySet()) {
            if (maxValue == 0) {
                maxValue = max.getValue();
                maxPerson = max.getKey();
            } else if (maxValue < max.getValue()) {
                maxValue = max.getValue();
                maxPerson = max.getKey();
            } else if (maxValue == max.getValue()) {
                deadHeat = true;
            }
            System.out.println();

        }
        printWinner(maxValue, maxPerson, deadHeat);
    }

    /*
     * печатает текст.....
     * */
    private static void printWinner(int maxValue, String maxPerson, boolean deadHeat) {
        if (deadHeat) {
            String txt = "|| Победила дружба!!! ||";
            printAnimationTxt(txt);
        } else {
            printAnimationTxt();
            String txt = "|| Победил " + maxPerson + " собрав " + maxValue + " роботов ||";
            printAnimationTxt(txt);
            printAnimationTxt();
        }
    }

    /*
     * печатает текст.....
     * */
    private static void printAnimationTxt(String txt) {
        char[] arr = txt.toCharArray();
        for (int i = 0; i < txt.length(); i++) {
            System.out.print(arr[i]);
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("");

    }

    /*
     * это тоже печатает анимацию....
     * */
    private static void printAnimationTxt() {
        for (int i = 0; i < 43; i++) {
            System.out.print("=");
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("");
    }
}
