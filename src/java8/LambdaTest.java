package java8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * User: lcl
 * Date: 2020-04-04
 */
public abstract class LambdaTest<T,R> {

    public void consumer(T user, Consumer<T> consumer){
        consumer.accept(user);
    }

    public T supplier(Supplier<T> supplier){
        return supplier.get();
    }

    public R function(T t, Function<T,R> function){
        return function.apply(t);
    }

    public boolean predicate(T t, Predicate<T> predicate){
        return predicate.test(t);
    }
}
