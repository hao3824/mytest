package java8;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Supplier 接口返回一个任意范型的值，和Function接口不同的是该接口没有任何参数
 * User: lcl
 * Date: 2020-03-31
 */
public class SupplierTest {
    private StringTest test = new StringTest();
    public static void main(String[] args) {
        Supplier<String> supplier = String::new;
        supplier.get();

        Consumer<String> consumer =p ->System.out.println(p.toUpperCase());
        consumer.accept("hahahbbbb");


    }
    public String supplierTest(){
        return test.supplier(()->"1111");
    }
    public void consumerTest(){
        String a = supplierTest();
        test.consumer(a,s -> System.out.println(s));
    }
    public String functionTest (){
        String a =supplierTest();
        return test.function(a,s -> s+"");

    }
    public boolean predicateTest(){
        return true;
    }
    @Test
    public void test(){
        String a = supplierTest();
        String b = functionTest();
        if (test.predicate(a,s->s.equals(b))){
            System.out.println("success");
        }
    }
    class StringTest extends LambdaTest<String,String>{}
}
