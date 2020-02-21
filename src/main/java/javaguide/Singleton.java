package javaguide;

/**
 * 双重校验锁实现对象单例（线程安全）
 */
public class Singleton {

    private volatile static Singleton uniqueInstance;

    private Singleton() {

    }

}
