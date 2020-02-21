package mutithreadinaction;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    public static class MyTask implements Runnable{
        @Override
        public void run() {
            //打印当前时间和当前的线程ID
            System.out.println(System.currentTimeMillis() + ":Thread ID:"
                +Thread.currentThread().getId());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {
            MyTask task = new MyTask();
            ExecutorService es = Executors.newFixedThreadPool(5);
            for (int i = 0; i < 10; i++) {
                es.submit(task);
            }
        }

    }
}
