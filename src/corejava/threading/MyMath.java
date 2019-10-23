package corejava.threading;

/**
 * @author Akash Patra
 */
public class MyMath {

    public void printNumbers(int n) throws InterruptedException {
        synchronized (this) {
            for (int i = 1; i <= n; i++) {
                System.out.println(Thread.currentThread().getName() + " :: " + i);
                Thread.sleep(500);
            }
        }
    }
}
