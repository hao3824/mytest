package AQS;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore 类似于操作系统中的信号量，可以控制对互斥资源的访问线程数。
 * User: lcl
 * Date: 2020-10-16
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        final int num = 3;
        final int threadNum = 10;
        Semaphore semaphore = new Semaphore(num);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < threadNum; i++) {
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    System.out.print(semaphore.availablePermits()+" ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            });
        }
    }


}
