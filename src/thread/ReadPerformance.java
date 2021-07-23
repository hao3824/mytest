package thread;

import org.elasticsearch.common.StopWatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * User: lcl
 * Date: 2021-03-09
 */
public class ReadPerformance {
    public static void main(String[] args) {
        List<Integer> copyOnWriteArraylist = new CopyOnWriteArrayList<>();
        List<Integer> synchronizedList = Collections.synchronizedList(new ArrayList<>());
        Vector<Integer> vector = new Vector<>();
        addAll(copyOnWriteArraylist);
        addAll(synchronizedList);
        addAll(vector);
        StopWatch stopWatch = new StopWatch();
        int loopCount = 100000;
        stopWatch.start("read:copyOnWriteArrayList");
        IntStream.rangeClosed(1,loopCount).parallel().forEach(a ->copyOnWriteArraylist.get(ThreadLocalRandom.current().nextInt(loopCount)));
        stopWatch.stop();
        stopWatch.start("read:synchronizedList");
        IntStream.rangeClosed(1,loopCount).parallel().forEach(a ->synchronizedList.get(ThreadLocalRandom.current().nextInt(loopCount)));
        stopWatch.stop();
        stopWatch.start("read:vector");
        IntStream.rangeClosed(1,loopCount).parallel().forEach(a ->vector.get(ThreadLocalRandom.current().nextInt(loopCount)));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
        System.out.println("copy:"+copyOnWriteArraylist.size());
        System.out.println("sync:"+synchronizedList.size());
        System.out.println("vector:"+vector.size());
    }
    private static void addAll(List<Integer> list){
        list.addAll(IntStream.rangeClosed(1,1000000).boxed().collect(Collectors.toList()));
    }
}
