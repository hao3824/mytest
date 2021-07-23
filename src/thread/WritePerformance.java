package thread;




import org.elasticsearch.common.StopWatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 * User: lcl
 * Date: 2021-03-09
 */
public class WritePerformance {
    public static void main(String[] args) {
        List<Integer> copyOnWriteArraylist = new CopyOnWriteArrayList<>();
        List<Integer> synchronizedList = Collections.synchronizedList(new ArrayList<>());
        Vector<Integer> vector = new Vector<>();
        StopWatch stopWatch = new StopWatch();
        int loopCount = 100000;
        stopWatch.start("write:copyOnWriteArrayList");
        IntStream.rangeClosed(1,loopCount).parallel().forEach(a ->copyOnWriteArraylist.add(ThreadLocalRandom.current().nextInt(loopCount)));
        stopWatch.stop();
        stopWatch.start("write:synchronizedList");
        IntStream.rangeClosed(1,loopCount).parallel().forEach(a ->synchronizedList.add(ThreadLocalRandom.current().nextInt(loopCount)));
        stopWatch.stop();
        stopWatch.start("write:vector");
        IntStream.rangeClosed(1,loopCount).parallel().forEach(a ->vector.add(ThreadLocalRandom.current().nextInt(loopCount)));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
        System.out.println("copy:"+copyOnWriteArraylist.size());
        System.out.println("sync:"+synchronizedList.size());
        System.out.println("vector:"+vector.size());
    }
}
