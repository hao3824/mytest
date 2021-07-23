package any;

/**
 * User: lcl
 * Date: 2020-10-09
 */
public class A {
    private static int a1;
    private int a2;

    static {
        System.out.println("A类静态属性a1:"+a1);
        System.out.println("A类静态代码块");
    }

    {
        System.out.println("A类非静态属性："+a2);
        System.out.println("A类非静态代码块");
    }
    public A(){
        System.out.println("A类构造方法执行。");
    }
}
