package corejava.threading.producer_consumer;

import java.util.List;

/**
 * @author Akash Patra
 */
public class Producer implements Runnable {

    private final List<Integer> taskQueue;
    private final int MAX_CAPACITY;
    private static boolean flag = false;

    public Producer(List<Integer> shareQueue, int size) {
        this.taskQueue = shareQueue;
        this.MAX_CAPACITY = size;
    }

    @Override
    public void run() {
        int counter = 0;
        while (true) {
            try {
                produce(counter++);
            } catch (InterruptedException e) {
                System.out.println("Producer -> InterruptedException");
            }
        }
    }

    private void produce(int i) throws InterruptedException {
        synchronized (taskQueue) {
            while (taskQueue.size() == MAX_CAPACITY) {
                System.out.println("Queue is full " + Thread.currentThread().getName()
                        + " is waiting, size: " + taskQueue.size());

                taskQueue.wait();
                System.out.println("Again ready to create.");
            }

            taskQueue.add(i);
            System.out.println("Produced: " + i);
            taskQueue.notifyAll();
        }

        if (i < 20) {
            Thread.sleep(500);
        } else {
            if (!flag) {
                System.out.println("Reached limit, it will slow down");
                flag = true;
            }
            Thread.sleep(8000);
        }
    }
}
