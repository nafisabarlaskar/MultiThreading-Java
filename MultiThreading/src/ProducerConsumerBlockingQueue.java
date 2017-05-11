import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by NafisaBarlaskar on 31-01-2017.
 */
public class ProducerConsumerBlockingQueue {

    public static void main(String[] args){

        BlockingQueue blockingQueue = new LinkedBlockingDeque();

        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++){
                    System.out.println("Produced "+i);
                    try {
                        blockingQueue.put(i);
                    } catch (InterruptedException ie){
                        System.out.println(ie);
                    }
                }
            }
        });

        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0 ; i < 10; i++){
                    try{
                        System.out.println("Consumed " + blockingQueue.take());
                    }catch (InterruptedException ie){
                        System.out.println(ie);
                    }
                }
            }
        });

        producerThread.start();
        consumerThread.start();

        try {
            consumerThread.join();
        } catch (InterruptedException ie){
            System.out.println(ie);
        }

        try {
            producerThread.join();
        } catch (InterruptedException ie){
            System.out.println(ie);
        }


    }
}
