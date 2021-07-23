package AQS;

import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.*;

/**
 * User: lcl
 * Date: 2020-07-01
 */
public class CountDownLatchTest {
    private static final int theadNum = 20;

    public static void main(String[] args) throws Exception {
        final CountDownLatch latch = new CountDownLatch(theadNum);
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < theadNum; i++) {
            final int num = i;
            service.execute(() -> {
                try {
                    test(num);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }

            });

        }
//        latch.await(5, TimeUnit.MILLISECONDS);
        latch.await();
        System.out.println("finish");
        service.shutdown();
    }

    static void test(int i) throws Exception{
        Thread.sleep(10);
        System.out.println("thead:" + i);
    }

}
