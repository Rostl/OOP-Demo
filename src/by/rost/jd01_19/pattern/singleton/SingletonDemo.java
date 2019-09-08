package by.rost.jd01_19.pattern.singleton;

public class SingletonDemo {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton == Singleton.getInstance());
        System.out.println(singleton == Singleton.getInstance());
        System.out.println(singleton == Singleton.getInstance());


        singleton.doSmth();
    }
}
