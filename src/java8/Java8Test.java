package java8;

import java.util.ArrayList;
import java.util.List;

/**
 * java8各种中间操作用法。包括sorted，filter，reduce等
 * User: lcl
 * Date: 2020-03-31
 */
public class Java8Test {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("aaa1");
        stringList.add("aaa2");
        stringList.add("bbb2");
        stringList.add("bbb3");
        stringList.add("ccc");
        stringList.add("ddd1");
        stringList.add("ddd5");
        stringList.add("eeee1");
        //sorted排序，无参数按默认排序
        //filter过滤
        stringList.stream()
                .sorted()
                .filter(s -> s.endsWith("1"))
                .forEach(System.out::println);
    }
}
