package corejava.threading;

/**
 * @author Akash Patra
 */
public class Sample {

    public static void main(String[] args) {
        MyMath myMath = new MyMath();

        Runnable r = () -> {
            try {
                myMath.printNumbers(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        new Thread(r, "ONE").start();
        new Thread(r, "TWO").start();

        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
        long diff = (endTime - startTime) / 1000;
        System.out.println("Time took: " + diff);
    }
}
