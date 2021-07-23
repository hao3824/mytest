package any;

/**
 * User: lcl
 * Date: 2020-10-09
 */
public class D implements C{

    @Override
    public void cc() {
        System.out.println("D类方法输出");
    }
    public D(){
        cc();
        System.out.println("D类构造方法");
    }
}
