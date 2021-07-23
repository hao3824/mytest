import org.junit.platform.commons.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test1 {
    public static String getNumberFilter(String[] args,String field) {
        if(args.length == 0 ) {
            return "";
        }
        if(args.length == 1 && (null!=(args[0])||"undefined".equalsIgnoreCase(args[0]))) {
            return "";
        }
        StringBuffer bs = new StringBuffer();
        bs.append("AND (");
        for (int i = 0; i < args.length; i++) {
            if(i > 0) {
                bs.append(" OR ");
            }
            if(args[i].indexOf("--") > 0) {
                String[] number = args[i].split("--");
                bs.append(" (");
                bs.append("UPPER(").append(field).append(") >= '" + number[0].trim().toUpperCase()
                        + "' and UPPER(").append(field).append(") <= '" + number[1].trim().toUpperCase() + "')");
                //bs.append(" OR (UPPER(").append(field).append(") = '" + args[i].trim().toUpperCase() + "')");
            } else {
                bs.append(" UPPER(").append(field).append(") = '" + args[i].trim().toUpperCase() + "'");
            }
        }
        bs.append(")");
        return bs.toString();
    }

    public static String getNumberFilterWithoutNumberRange(String[] args, String field) {
        if (args.length == 0) {
            return "";
        }
        if (args.length == 1 && (null !=(args[0]) || "undefined".equalsIgnoreCase(args[0]))) {
            return "";
        }
        StringBuffer bs = new StringBuffer();
        bs.append("AND (");
        for (int i = 0; i < args.length; i++) {
            if (i > 0) {
                bs.append(" OR ");
            }

            bs.append(" UPPER(").append(field).append(") = '" + args[i].trim().toUpperCase() + "'");
        }
        bs.append(")");
        return bs.toString();
    }
    public static String getType(Object o){ //获取变量类型方法
        return o.getClass().toString(); //使用int类型的getClass()方法
    }

    public static long getCompareDate(String startDate, String endDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = formatter.parse(startDate);
        Date date2 = formatter.parse(endDate);
        long l = date2.getTime() - date1.getTime();
        long d = l / (24 * 60 * 60 * 1000);
        return d;
    }

    public static String getTodayStr() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(new java.util.Date());
    }

    public static boolean isScientificNotation(String str) {
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("^([-]?[1-9]{1,1}\\.[0-9]+[E,e]{1,1}[\\+-]?[0-9]+)$");
        java.util.regex.Matcher match = pattern.matcher(str);
        return match.matches();
    }
    public static boolean isNumberSupportNegative(String str) {
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("^([-]?[0-9]+[\\.]?[0-9]+)|([-]?[0-9]+)$");
        java.util.regex.Matcher match = pattern.matcher(str);
        return match.matches();
    }

    public static void main(String[] args) throws Exception{
       /* String no = "SSIS-00001,SSIS-00002,SSIS-00003,SSIS-00004,SSIS-00005,SSIS-00006,SSIS-00007,SSIS-00008";
        String[] nos = no.split(",");
        String result = getNumberFilter(nos,"i.fnumber");
        String result2 = getNumberFilterWithoutNumberRange(nos,"i.fnumber");
        System.out.println("result1:"+result);
        System.out.println("result2:"+result2);*/

    /*  int i=14;
       long l = new Long(12789);
       long c = new Long(12789);
        System.out.println("i:"+getType(i));
        System.out.println("l:"+getType(l));
        System.out.println(l==c);*/

   /* String d1=null;
    String d2 = getTodayStr();



        System.out.println(getCompareDate(d2,d1));*/
   /*String a = "aaaaa88888888bbbbbddfddf".replaceAll("88888888","123456");
        System.out.println(a);*/
  /* String s="0";
   boolean a = isScientificNotation(s);
   boolean b = isNumberSupportNegative(s);
        System.out.println(a);
        System.out.println(b);*/

     /* int a=1;
      int b=a;
      a=a+1;
        System.out.println(a); //2
        System.out.println(b); //1*/

       /* List<String> list = new ArrayList<>();
        while(true){
            list.add("test");
        }
        */
       /* String a = "a";
        String b = new String("a");
        System.out.println(a.equals(b));

        int a1 = 130;
        Integer a2 = new Integer(130);
        Integer a3 = new Integer(130);
        System.out.println("a1=a2:"+(a1==a2));
        System.out.println("a2=a3:"+(a2.equals(a3)));*/
        /*String time = "2020-04-26 15:00:18.218";
        System.out.println(formatDate(time));*/

        Map<String,Integer> map = new HashMap<>();
        map.isEmpty();
        List<Long> ids = new ArrayList<>();
        ids.add(123L);
        ids.add(1234L);
        ids.add(12356L);
        ids.add(12367L);
        StringBuilder s =new StringBuilder("(");
        s.append(ids.get(0));
        for (int i = 1; i < ids.size(); i++) {
            s.append(",");
            s.append(ids.get(i));
        }
        s.append(")");
        System.out.println(s.toString());
    }

    public static String formatDate(String time){
        if(StringUtils.isNotBlank(time)){
            return time.split("\\.")[0];
        }
        return "";
    }
}
