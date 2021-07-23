package AQS;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 用来控制多个线程互相等待，只有当多个线程都到达时，这些线程才会继续执行。
 *
 * 和 CountdownLatch 相似，都是通过维护计数器来实现的。线程执行 await() 方法之后计数器会减 1，并进行等待，
 * 直到计数器为 0，所有调用 await() 方法而在等待的线程才能继续执行。
 *
 * CyclicBarrier 和 CountdownLatch 的一个区别是，CyclicBarrier 的计数器通过调用 reset() 方法可以循环使用，
 * 所以它才叫做循环屏障。
 *
 * CyclicBarrier 有两个构造函数，其中 parties 指示计数器的初始值，barrierAction 在所有线程都到达屏障的时候会执行一次。
 * CountDownLatch 是一次性的，CyclicBarrier 是可循环利用的
 * CountDownLatch 参与的线程的职责是不一样的，有的在倒计时，有的在等待倒计时结束。CyclicBarrier 参与的线程职责是一样的。
 *
 * User: lcl
 * Date: 2020-10-15
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        final int total = 10;
        CyclicBarrier barrier = new CyclicBarrier(total);
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i <total ; i++) {
            pool.execute(()->{
                System.out.println("before..");
                try {
                    barrier.await();

                    System.out.println("hahahh");
                    barrier.await();// CyclicBarrier 可以有不止一个栅栏
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("after..");
            });
        }
        pool.shutdown();
    }
}
