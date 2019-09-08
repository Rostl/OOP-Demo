package by.rost.jd01_6;

public class Rectangle extends Point{

    Point A;
    Point B;
    private double rectPoint;

    public double getRectPoint() {
        return rectPoint;
    }

    public void setRectPoint(int rectPoint) {
        this.rectPoint = rectPoint;
    }

    public Point getA() {
        return A;
    }

    public void setA(Point a) {
        A = a;
    }

    public Point getB() {
        return B;
    }

    public void setB(Point b) {
        B = b;
    }

    //Расчет площади по 2-м точкам
    public static double sq(Rectangle rect) {
        double rectlenght;
        double rectHeight;
        if (rect.A.getX() > rect.B.getX()) {
            rectlenght = rect.A.getX() - rect.B.getX();
        } else {
            rectlenght = rect.B.getX() - rect.A.getX();
        }
        if (rect.A.getY() > rect.B.getY()) {
            rectHeight = rect.A.getY() - rect.B.getY();
        } else {
            rectHeight = rect.B.getY() - rect.A.getY();
        }
        return rectHeight * rectlenght;
    }

    //находит диагональ
    public double hypotenuse(Point a, Point b) {

      return distance( a, b);
    }
}
