package by.rost.jd01_10;

public class MainCar {
    public static void main(String[] args) {
        Opel opel = new Opel("Opel", "Astra", "2005", "1997", "White");
        Opel opel2 = new Opel("Opel", "Astra", "2005", "1997", "White");
        Opel opel3 = new Opel("Opel", "Vectra", "2003", "1357", "red");
        Opel opel4 = new Opel("Opel", "Indsignia", "2017", "5097", "black");
        Opel opel5 = new Opel("Opel", "corsa", "2015", "1400", "yellow");
        BMW bmw1 = new BMW("BMW", "i3", "2015", "1800", "blue");
        BMW bmw2 = new BMW("BMW", "i3", "2015", "1800", "blue");
        BMW bmw3 = new BMW("BMW", "X3", "2010", "1900", "Pink");
        BMW bmw4 = new BMW("BMW", "X6", "2017", "4000", "Black");
        BMW bmw5 = new BMW("BMW", "X2", "2012", "1900", "Gray");
        BMW bmw6 = new BMW("BMW", "X6", "2017", "4000", "Black");

        Garage myGarage = new Garage();
        /*
         * Парковка автоиобилей в гараж
         * */
        myGarage.parking(opel);
        myGarage.parking(opel2);
        myGarage.parking(opel3);
        myGarage.parking(opel4);
        myGarage.parking(bmw1);
        myGarage.parking(bmw2);
        myGarage.parking(bmw3);
        myGarage.parking(bmw4);
        myGarage.parking(bmw5);
        myGarage.parking(bmw6);
        /*
         * Вывод на консоль всех автомобилей
         * */
        myGarage.printCars();
        System.out.println();
        System.out.println();
        /*
         * Выезд автомобилей из гаража
         * */
        myGarage.removeCar(opel5);
        myGarage.removeCar(opel3);
        myGarage.removeCar(bmw5);
        /*
         * Вывод на консоль по брэнду
         * */
        myGarage.sortAsBrand("Opel");
        myGarage.sortAsBrand("BMW");
    }
}