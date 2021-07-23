/**
 * wait()方法和notify()方法要拿到对象锁。对锁对象进行操作
 * User: lcl
 * Date: 2021-05-08
 */
public class NotifyTest {
      static Object o = new Object();

    public static void main(String[] args) {

        Thread a = new ThreadA();
        a.start();
        System.out.println("a is start...");
        synchronized (o){
            try {
                System.out.println("waiting !.......");
                o.wait();
                System.out.println("completed!......");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("total is:"+((ThreadA) a).total);
    }

    static class ThreadA extends Thread {
        int total;

        @Override
        public void run() {
            synchronized (o) {
                System.out.println("Thread is running...");
                for (int i = 0; i < 5; i++) {
                    total += i;
                    System.out.println("total :" + total);
                }
                o.notify();
            }

        }
    }

}