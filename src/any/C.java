package any;

/**
 * User: lcl
 * Date: 2020-10-09
 */
public interface C {
    default void mc(){
        System.out.println("C接口默认方法");
    }
    void cc();
}
