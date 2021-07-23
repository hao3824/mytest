import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Random;

public class CheckCodeTest {
    private static char[] c = new char[]{'+','-','*'};
    private static String genetateCode(){
        Random rd = new Random();
        int code1= rd.nextInt(10);
        int code2= rd.nextInt(10);
        int code3= rd.nextInt(10);
        char c1= c[rd.nextInt(3)];
        char c2= c[rd.nextInt(3)];

        return ""+code1+c1+code2+c2+code3;
    }

    private static int cal(String codes) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        return (Integer) engine.eval(codes);

    }
    public static void main(String[] args) throws ScriptException {
        String codes = genetateCode();
        System.out.println(codes);
        System.out.println(cal(codes));
    }
}
