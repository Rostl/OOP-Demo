package by.rost.jd01_10;

import java.util.HashMap;
import java.util.Map;

public class Garage {
    private Map<Car, Integer> hashMaCar = new HashMap<>();

    /*
     * Добавляет и подсчитывает автомобили в гараж (HashMap)
     * */
    public void parking(Car car) {
        if (hashMaCar.get(car) != null) {
            hashMaCar.put(car, hashMaCar.get(car) + 1);
        } else {
            hashMaCar.put(car, 1);
        }
    }

    /*
     * Удаляет автомобили из гаража(HashMap)
     * */
    public void removeCar(Car car) {
        if (hashMaCar.get(car) == null) {
            System.out.println(car + " эта машина отсутствует в гараже");
            System.out.println();
        } else if (hashMaCar.get(car) > 1) {
            System.out.println(car + " покидает гараж");
            hashMaCar.put(car, hashMaCar.get(car) - 1);
            System.out.println();
        } else {
            System.out.println(car + " покидает гараж");
            hashMaCar.remove(car);
            System.out.println();
        }
    }

    /*
     * Выводит на консоль автомобили в HashMap по производителю
     * */
    public void sortAsBrand(String carBrand) {
        System.out.println("Оставшиеся в гараже автомобили по производителю  --> " + carBrand);
        for (Map.Entry<Car, Integer> entry : hashMaCar.entrySet()) {
            if (entry.getKey().getBrand().equals(carBrand)) {
                System.out.printf("%-110s%-5s%n", entry.getKey(), entry.getValue());
            }
        }
        System.out.println();
    }

    /*
     * Выводит общее количество автомобилей в HashMap
     * */
    public void printCars() {
        System.out.printf("%-110s%-5s%n", "Автомобили в гараже", "Количество");
        for (Map.Entry<Car, Integer> entry : hashMaCar.entrySet()) {
            System.out.printf("%-110s%-5s%n", entry.getKey(), entry.getValue());
        }
    }
}