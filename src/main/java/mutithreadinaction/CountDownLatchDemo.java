package mutithreadinaction;

import java.util.Random;
import java.util.concurrent.*;

public class CountDownLatchDemo implements Runnable {
    static final CountDownLatch end = new CountDownLatch(10);
    static final CountDownLatchDemo countDownLatchDemo = new CountDownLatchDemo();

    @Override
    public void run() {
        try {
            //模拟检查任务
            Thread.sleep(new Random().nextInt(10) * 1000);
            System.out.println("check complete");
            end.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            exec.submit(countDownLatchDemo);
        }
        end.await();
        System.out.println("Fire!");
        exec.shutdown();
    }
}
