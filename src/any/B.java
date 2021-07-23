package any;

/**
 * User: lcl
 * Date: 2020-10-09
 */
public class B extends A{

    private static int b1;
    private int b2;

    static {
        System.out.println("B类静态属性b1:"+b1);
        System.out.println("B类静态代码块");
    }

    {
        System.out.println("B类非静态属性："+b2);
        System.out.println("B类非静态代码块");
    }
    public B(){
        System.out.println("B类构造方法执行。");
    }
}
