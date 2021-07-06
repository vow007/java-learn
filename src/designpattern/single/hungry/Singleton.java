package designpattern.single.hungry;

/**
 * 饿汉式
 */
//public class Singleton {
//
//    private static Singleton instance = new Singleton();
//
//    private Singleton() {
//    }
//
//    public static Singleton getInstance() {
//        return instance;
//
//    }
//}

/**
 * 饿汉式变种
 */
public class Singleton {
    private static Singleton instance = null;

    static {
        instance = new Singleton();
    }

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }
}