package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * User: lcl
 * Date: 2020-10-16
 */
public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int result = 0;
                for (int i = 0; i <=100 ; i++) {
                    result+=i;
                }
                return result;
            }
        });
        Thread thread = new Thread(task);
        thread.start();
        System.out.println("main thread is running");
        System.out.println(task.get());
    }
}
