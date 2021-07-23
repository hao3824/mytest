package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: lcl
 * Date: 2021-03-01
 */
public class ThreadLocalTest {


    public static void main(String[] args) {
        //用线程
        ThreadLocal<Long> num = ThreadLocal.withInitial(()->1L);
       /* for (int i = 0; i < 10; i++) {
            new Thread(()->{
                long a = num.get();
                System.out.println("before:"+num.get());
                num.set(++a);
                System.out.println("after:"+num.get());
            }).start();
        }
        System.out.println("main:"+num.get());*/

       //用线程池,线程重用会产生串数据问题。
        ExecutorService tp = Executors.newCachedThreadPool();
        for (int i = 0; i <20 ; i++) {
            System.out.println(i);
            tp.execute(()->{
                long a = num.get();
                System.out.println("before:"+num.get());
                num.set(++a);
                System.out.println("after:"+num.get());
                //解决串数据
                num.remove();
            });
        }

    }

}
