package corejava.threading.producer_consumer;

import java.util.List;

/**
 * @author Akash Patra
 */
public class Consumer implements Runnable {

    private final List<Integer> taskQueue;

    public Consumer(List<Integer> shareQueue) {
        this.taskQueue = shareQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                consume();
            } catch (InterruptedException e) {
                System.out.println("Consumer -> InterruptedException");
            }
        }
    }

    private void consume() throws InterruptedException {
        synchronized (taskQueue) {
            while (taskQueue.isEmpty()) {
                System.out.println("Queue is empty " + Thread.currentThread().getName() +
                        " is waiting, size: " + taskQueue.size());
                taskQueue.wait();
                System.out.println("Again ready to consume.");
            }

            int i = taskQueue.remove(0);
            System.out.println("Consumed: " + i);
            taskQueue.notifyAll();
        }

        Thread.sleep(2000);
    }
}
