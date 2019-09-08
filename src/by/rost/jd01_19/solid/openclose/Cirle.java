package by.rost.jd01_19.solid.openclose;

public class Cirle implements Figure {

    private int radius;

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    public Cirle(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }
}
