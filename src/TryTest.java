import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class TryTest {
    public static void main(String[] args) {

        /*StringBuilder a = new StringBuilder();
        System.out.println(a.toString());
        Optional<Integer> result = Stream.of("a", "be", "hello")
                .map(s -> s.length())
                .filter(l -> l <= 3)
                .max((o1, o2) -> o1-o2);
        System.out.println(result.get()); // 输出2*/

        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("aaa",1);
        map.put("bbb",2);
        map.get("aaa");
        List list = new ArrayList();
        Map map1 = new HashMap();
        map1.put("hahha",1);
    }
}
