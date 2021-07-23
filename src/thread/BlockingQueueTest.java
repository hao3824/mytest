package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * User: lcl
 * Date: 2020-10-16
 */
public class BlockingQueueTest {
    private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
    private static class Producer extends Thread{
        @Override
        public void run(){
            try {
                queue.put("hello");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("produce");
        }
    }
    private static class Consumer extends Thread{
        @Override
        public void run(){
            try {
                String content =queue.take();
                System.out.println("content:"+content);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <2 ; i++) {
            Producer producer = new Producer();
            producer.sleep(1000);
            producer.start();
        }
        for (int i = 0; i <5 ; i++) {
            Consumer consumer = new Consumer();
            consumer.start();
        }
        for (int i = 0; i <3 ; i++) {
            Producer producer = new Producer();
            producer.sleep(1000);
            producer.start();
        }
    }
}
