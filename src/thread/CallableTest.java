package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * User: lcl
 * Date: 2020-10-15
 */
public class CallableTest implements Callable {
    @Override
    public String call() throws Exception {
        return "hello";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable call = new CallableTest();
        FutureTask<String> task = new FutureTask<>(call);
        Thread thread = new Thread(task);
        thread.start();
        System.out.println(task.get());
    }
}
