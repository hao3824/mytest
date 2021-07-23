/**
 * User: lcl
 * Date: 2021-03-19
 */
public class Singleton {
    private Singleton(){}
    private static class Inner{
        private final static Singleton instance = new Singleton();
    }
    public Singleton getInstance(){
        return Inner.instance;
    }
}
