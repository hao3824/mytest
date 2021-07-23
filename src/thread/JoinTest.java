package thread;

import any.B;
import org.junit.jupiter.api.Test;

/**在线程中调用另一个线程的 join() 方法，会将当前线程挂起，而不是忙等待，直到目标线程结束。
 对于以下代码，虽然 b 线程先启动，但是因为在 b 线程中调用了 a 线程的 join() 方法，b 线程会等待 a
 线程结束才继续执行，因此最后能够保证 a 线程的输出先于 b 线程的输出。
 * User: lcl
 * Date: 2020-10-22
 */
public class JoinTest {
    private class A extends Thread{
        @Override
        public void run() {
            System.out.println("A");
        }
    }
    private class B extends Thread{
        private A a;
        public B(A a){
            this.a =a;
        }
        @Override
        public void run() {
            try {
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B");
        }
    }
    private class C extends Thread{
        private JoinTest.B b;
        public C(JoinTest.B b){
            this.b =b;
        }
        @Override
        public void run() {
            try {
                b.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("C");
        }
    }
    private class D extends Thread{
        private C c;
        public D(C c){
            this.c =c;
        }
        @Override
        public void run() {
            try {
                c.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("D");
        }
    }

    @Test
    public  void test() {
        A a = new A();
        B b = new B(a);
        C c = new C(b);
        D d = new D(c);
        d.start();
        c.start();
        b.start();
        a.start();
    }
    /*执行结果：
    A
    B
    C
    D*/
}
