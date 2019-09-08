package by.rost.jd01_19.solid.openclose;

public class Square implements Figure {

    private int side;

    public Square(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    @Override
    public double area() {
        return side * side;
    }
}
