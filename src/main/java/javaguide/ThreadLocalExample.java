package javaguide;

public class ThreadLocalExample {

    String str1 = null;

    /**
     * ThredLocal变量是每个线程独有的
     */
    ThreadLocal<String> stringThreadLocal = ThreadLocal.withInitial(() -> new String());


}
