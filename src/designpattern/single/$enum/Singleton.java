package designpattern.single.$enum;

/*既能避免多线程同步问题，又能防止反序列化重新创建新的对象。*/
public enum Singleton {
    INSTANCE;
}