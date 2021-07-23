package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * stream 与 parallelStream 区别。parallelStream是多线程，更快。stream单线程。
 * User: lcl
 * Date: 2020-03-30
 */
public class StreamTest {
    public static void main(String[] args) {
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i <max ; i++) {
            String uuid = UUID.randomUUID().toString();
            values.add(uuid);
        }
        long t1 = System.nanoTime();
        long count1 = values.stream().sorted().count();
        System.out.println("count1:"+count1);
        long t2 = System.nanoTime();
        long t3 = TimeUnit.NANOSECONDS.toMillis(t2-t1);
        System.out.println("t1:"+t3);
        long t4 = System.nanoTime();
        long count2 = values.parallelStream().sorted().count();
        System.out.println("count2:"+count2);
        long t6 = System.nanoTime();
        long t7 = TimeUnit.NANOSECONDS.toMillis(t6-t4);
        System.out.println("t1:"+t7);
    }
}
