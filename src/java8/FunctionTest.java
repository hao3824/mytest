package java8;

import java.util.function.Function;

/**
 * 以前看待Java的眼光已经不同了，在函数式编程之前我们定义一组操作首先想到的是定义一个方法，
 * 然后指定传入参数，返回我们需要的结果。函数式编程的思想是先不去考虑具体的行为，而是先去考虑参数，具体的方法我们可以后续再设置。
 * Function函数加入了@FunctionalInterface注解，是函数式接口
 * Function<T,R> T为参数，R为返回值
 * 方法：apply执行，compose先执行apply里面的，后执行本Function。andThen先执行本function，后执行apply里面的function.
 * User: lcl
 * Date: 2020-03-31
 */
public class FunctionTest {
    public static void main(String[] args) {
        Function<Integer,Integer> test1= i->i*i;
        Function<Integer,Integer> test2= i->i+2;
        Integer a = cal(test1,5);
        Integer b = cal(test2,5);
        System.out.println(a);
        System.out.println(b);
        //Integer是参数，String是返回值
        Function<Integer,String> test3 = i->i.toString();
        String c = test3.apply(11);
        System.out.println(c);
        //7*(5+2)=49
        Integer d = test1.compose(test2).apply(5);//49
        //5*5+2=27
        Integer e = test1.andThen(test2).apply(5);//27
        System.out.println("d:"+d);
        System.out.println("e:"+e);
    }
    public static Integer cal(Function<Integer,Integer> a,Integer b){
        return a.apply(b);
    }
}
