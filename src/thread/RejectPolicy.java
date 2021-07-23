package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * User: lcl
 * Date: 2021-02-05
 */
public class RejectPolicy {
    private static final int core = 1;
    private static final int max = 1;

    public static void main(String[] args) throws Exception {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(core, max, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(max));
        //将"线程池的拒绝策略"由DiscardPolicy修改为AbortPolicy之后，当有任务添加到线程池被拒绝时，会抛出RejectedExecutionException。
//        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        //将"线程池的拒绝策略"由DiscardPolicy修改为CallerRunsPolicy之后，当有任务添加到线程池被拒绝时，线程池会将被拒绝的任务添加到"线程池正在运行的线程"中取运行。
//        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //将"线程池的拒绝策略"由DiscardPolicy修改为DiscardOldestPolicy之后，当有任务添加到线程池被拒绝时，线程池会丢弃阻塞队列中末尾的任务，然后将被拒绝的任务添加到末尾。
//        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
        //DiscardPolicy 线程池中共运行了2个任务。第1个任务直接放到Worker中，通过线程去执行；第2个任务放到阻塞队列中等待。其他的任务都被丢弃了！
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());

        for (int i = 0; i < 10; i++) {
//           executor.execute(()->{
//               System.out.println(Thread.currentThread().getName()+Thread.currentThread().getId()+"is running");
//           });
            // 新建10个任务，并将它们添加到线程池中。

                Runnable myrun = new MyThread("task-"+i);
                executor.execute(myrun);

        }
        executor.shutdown();
    }

}

class MyThread implements Runnable {
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " is running");
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}