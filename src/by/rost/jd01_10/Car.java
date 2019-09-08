package by.rost.jd01_10;

import java.util.Objects;

public abstract class Car {
    private String brand;
    private String model;
    private String manufactureYear;
    private String angineCapacity;
    private String color;

    public Car(String brand, String model, String manufactureYear, String angineCapacity, String color) {
        this.brand = brand;
        this.model = model;
        this.manufactureYear = manufactureYear;
        this.angineCapacity = angineCapacity;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", manufactureYear='" + manufactureYear + '\'' +
                ", angineCapacity='" + angineCapacity + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(brand, car.brand) &&
                Objects.equals(model, car.model) &&
                Objects.equals(manufactureYear, car.manufactureYear) &&
                Objects.equals(angineCapacity, car.angineCapacity) &&
                Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {

        return Objects.hash(brand, model, manufactureYear, angineCapacity, color);
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getManufactureYear() {
        return manufactureYear;
    }

    public String getAngineCapacity() {
        return angineCapacity;
    }

    public String getColor() {
        return color;
    }
}