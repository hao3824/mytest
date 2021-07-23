import java.util.ArrayList;
import java.util.List;

/**泛型通配符 extends适合读数据，supper适合写数据
 * PECS
 * User: lcl
 * Date: 2020-04-03
 */
public class FanxingTest {
    public static void main(String[] args) {
        List<? extends Number> a = new ArrayList<Integer>();//可以放子类
//        Number d = a.get(0);//取只能是本身或父类
//        Object i = a.get(0);


//        a.add(new Integer(1));//报错，不能往里面存东西，只能往外取

        List<? super Number> b = new ArrayList<Object>();
        b.add(new Integer(2));//可以往里面存，但是取出来只能用Object类
        b.add(2.5);
//        Number e = b.get(0); //报错
        Object c = b.get(0);
        ArrayList<Double> cd = new ArrayList<>();
        cd.add(12.3);
        cd.add(12.5);
        extend(cd);
        ArrayList<Object> ob = new ArrayList<>();
        ob.add("hahahha");
        ob.add(123);
        sup(ob);
    }

    private static void extend(List<? extends Number> list){
        if (list!=null && list.size()>0){
            for (int i = 0; i <list.size() ; i++) {
                System.out.println(list.get(i));

            }
        }
    }
    private static void sup(List<? super Number> list){
        if (list!=null && list.size()>0){
            for (int i = 0; i <list.size() ; i++) {
                System.out.println(list.get(i));

            }
        }
    }

}
