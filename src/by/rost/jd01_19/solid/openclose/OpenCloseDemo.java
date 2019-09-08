package by.rost.jd01_19.solid.openclose;

public class OpenCloseDemo {

    public static void main(String[] args) {
        Cirle cirle = new Cirle(5);
        Square square = new Square(7);
        Rectangle rectangle = new Rectangle(4, 6);
        double result = AreaSummarizer.summarize(cirle, square, rectangle);
        System.out.println(result);
    }
}
