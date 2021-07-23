import java.math.BigDecimal;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {
    public static void main(String[] args) {

       /* Pattern pt = Pattern.compile("^(?!_)(?!-)(?!.*?_$)(?!.*?-$)[0-9a-zA-Z-_\u4e00-\u9fa5]+$");
        String s1 = "HLYCY01-20181023-017_18_19";
        String s2 = "HLYCY01-20181024-022/023";
        String s3 = "HLYCY03-20190326-033031-B";
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("^([0-9]+\\.[0-9]+)|([0-9]+)$");
        String o = "16240943.988000002";*/

//        System.out.println(pt.matcher(s1).matches());
//        System.out.println(pt.matcher(s2).matches());
//        System.out.println(pt.matcher(s3).matches());
      /*  System.out.println(pattern.matcher(o).matches());
        System.out.println(o.toString());*/
//      String a = new BigDecimal("0.99").scaleByPowerOfTen(1).toPlainString();
//        System.out.println(a);
       /* List<Object> list = null;
        for (Object b:list){

            System.out.println(b);
        }*/
       /*Object a = null;
        System.out.println(a.toString());*/

      /* BigDecimal a = BigDecimal.valueOf(-0.4);
        System.out.println(a.compareTo(BigDecimal.ZERO));
        String word = "hello world hahahahhaha ";
        int size = word.length();
        for (int i = size-1; i <0 ; i--) {

        }*/
  /*    BigDecimal a = new BigDecimal("100.01000000");
        System.out.println(a.stripTrailingZeros().toPlainString());*/

//  String[] s = null;
//        Arrays.stream(s).forEach(l-> System.out.println(l));

         String a = "aaaaa";
        final String b = a;
        a = "ssss";
//        String[] s = new String[]{};
//        for (String sr:s){
//            System.out.println(s);
//        }
//        Object a = null;
//        System.out.println("a:"+a.toString());
        System.out.println("a:"+a);
        System.out.println("b:"+b);

    }
}
