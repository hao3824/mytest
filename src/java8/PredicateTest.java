package java8;

import java.util.Objects;
import java.util.function.Predicate;
/**
 * Predicate 评估功能
 * test 方法，返回类型boolean，判断是否符合评估
 * add，or，negate 与，或，非，谓词
 * isEqual 是否相等，谓词
 * User: lcl
 * Date: 2020-03-27
 */
public class PredicateTest {
    public static void main(String[] args) {
        Predicate<String> predicate = (s) -> s.length() > 0;
        boolean a =predicate.test("foo");
        boolean a1 =predicate.negate().test("foo");
        Predicate<Boolean> nonNull = Objects::nonNull;
        boolean a2 =nonNull.test(null);
        boolean a3 =nonNull.test(true);
        Predicate<Boolean> isNull = Objects::isNull;
        boolean a4 =isNull.test(false);
        boolean a8 =isNull.test(null);
        Predicate<String> isEmpty = String::isEmpty;
        boolean a5 =isEmpty.test("");
        Predicate<String> isNotEmpty = isEmpty.negate();
        boolean a6 =isNotEmpty.test("");
        // or
        Predicate<String> string = isEmpty.or(isNotEmpty);
        boolean a9 = string.test("");
        //and
        Predicate<String> string1 = isEmpty.and(isNotEmpty);
        boolean a10 = string1.test("");
        //negate
        Predicate<String> negate = isEmpty.negate();
        boolean a11 = negate.test("");

//        得是同一个泛型
//        Predicate ha = isEmpty.and(isNull);
    }
}
