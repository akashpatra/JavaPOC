package corejava.threading.producer_consumer;

import java.util.ArrayList;
import java.util.List;

/**
 * Ref: https://howtodoinjava.com/java/multi-threading/wait-notify-and-notifyall-methods/
 *
 * @author Akash Patra
 */
public class ProducerConsumerExampleWithWaitAndNotify {

    public static void main(String[] args) {
        List<Integer> taskQueue = new ArrayList<>();
        int MAX_CAPACITY = 5;
        Thread tProducer = new Thread(new Producer(taskQueue, MAX_CAPACITY));
        tProducer.setName("Producer");

        Thread tConsumer = new Thread(new Consumer(taskQueue));
        tConsumer.setName("Consumer");

        // Start the Threads
        tProducer.start();
        tConsumer.start();
    }
}
