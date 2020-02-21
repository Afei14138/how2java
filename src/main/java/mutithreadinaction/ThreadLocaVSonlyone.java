package mutithreadinaction;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @program: mongomanager
 * @description: ThreadLocal变量与普通变量对性能的影响
 * @author: wpf
 * @create: 2019-12-28 11:40
 **/
public class ThreadLocaVSonlyone {
    public static final int GEN_COUNT = 10000000;
    public static final int THREAD_COUNT = 4;
    public static ExecutorService exe = Executors.newFixedThreadPool(THREAD_COUNT);
    public static Random rnd = new Random(123);
    public static ThreadLocal<Random> tRnd = new ThreadLocal<>(){
        @Override
        protected Random initialValue() {
            return new Random(123);
        }
    };

    public static class RndTask implements Callable<Long>{

        public int mode = 0;

        public RndTask(int mode){
            this.mode = mode;
        }

        public Random getRandom(){
            if(mode == 0){
                return rnd;
            } else if(mode == 1){
                return tRnd.get();
            } else{
                return null;
            }
        }

        @Override
        public Long call() throws Exception {
            Long b = System.currentTimeMillis();
            for (int i = 0; i < GEN_COUNT; i++) {
                getRandom().nextInt();
            }
            Long e = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + " spend "+(e-b)+"ms");
            return e - b;
        }
    }

    public static void main(String[] args) {
        Future<Long>[] futs = new Future[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            futs[i] = exe.submit(new RndTask(0));
        }
        
    }
}
