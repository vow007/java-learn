package designpattern.single.$static;

public class Singleton {
    private Singleton() {
    }

    private static class SingletonHolder {
        private static Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}