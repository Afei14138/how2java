/**
 * @Description: 带有时间戳的无锁引用$
 * @Author: wpf
 * @Date: $
 */
package mutithreadinaction.NoLockDemo;

import java.util.concurrent.atomic.AtomicStampedReference;

public class AutoStampedReferenceDemo {
    // 初始化时时间戳为0
    static AtomicStampedReference<Integer> money = new AtomicStampedReference<>(19, 0);

    public static void main(String[] args) {
        // 模拟多个线程同时更新数据库，为用户重置
        for (int i = 0; i < 3; i++) {
            final int timestamp = money.getStamp();
            new Thread(){
                @Override
                public void run(){
                    while (true){
                        while (true){
                            Integer m = money.getReference();
                            if(m < 20){
                                //判断时间戳
                                if(money.compareAndSet(m, m+20, timestamp, timestamp+1)) {
                                    System.out.println("余额小于20，充值成功，余额：" + money.getReference());
                                }
                            } else {
                                System.out.println("余额大于20");
                                break;
                            }

                        }
                    }
                }
            }.start();
        }

        // 模拟消费者线程进行消费
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    while (true){
                        int timestamp = money.getStamp();
                        Integer m = money.getReference();
                        if(m > 10){
                            System.out.println("大于十元");
                            if(money.compareAndSet(m, m-10, timestamp, timestamp+1)){
                                System.out.println("成功消费十元，余额" + money.getReference());
                                break;
                            }
                        } else {
                            System.out.println("没有足够余额");
                            break;
                        }
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();


    }



}
