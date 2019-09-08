package by.rost.jd01_6;

public class Main {
    public static void main(String[] args) {


        Point point1 = new Point();
        Point point2 = new Point();
        Point rectaPoint = new Point();
        Point rectaPointTwo = new Point();


        point1.setX(8.0);
        point1.setY(8.0);
        point2.setX(12.0);
        point2.setY(4.0);

        rectaPoint.setX(25.0);
        rectaPoint.setY(30.0);
        rectaPointTwo.setX(40.0);
        rectaPointTwo.setY(12);


        System.out.printf("Distance = %s", point1.distance(point1, point2));

        System.out.println("");

        Rectangle myRect = new Rectangle();
        myRect.setA(rectaPoint);
        myRect.setB(rectaPointTwo);
        System.out.printf("Square = %s", Rectangle.sq(myRect));
        System.out.println("");

        System.out.printf("гипотенуза = %s", myRect.hypotenuse(rectaPoint, rectaPointTwo));


    }
}
