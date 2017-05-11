import java.util.LinkedList;

/**
 * Created by NafisaBarlaskar on 04-03-2017.
 */
public class ProducerConsumerWaitNotify {

    public static void main(String[] args){

        final ProducerConsumer producerConsumer = new ProducerConsumer();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    producerConsumer.producer();
                } catch (InterruptedException ie){
                    ie.printStackTrace();
                }

            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    producerConsumer.consumer();
                } catch (InterruptedException ie){
                    ie.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException ie){
            ie.printStackTrace();
        }try {
            thread1.join();
        } catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }

    public static class ProducerConsumer {

        int capacity = 3;
        LinkedList<Integer> linkedList = new LinkedList<>();

        public void producer() throws InterruptedException {
            int counter = 3;
            int producedValue = 1;

            while(counter!=0){
                synchronized (this){
                    while (linkedList.size()==capacity){
                        wait();
                    }
                    System.out.println("Producer produced " + producedValue);
                    linkedList.add(producedValue++);
                    notify();
                    Thread.sleep(1000);
                    counter--;
                }
            }
        }

        public void consumer() throws InterruptedException {

            int counter = 3;
            while (counter!=0){
                synchronized (this){
                    while (linkedList.size()==0){
                        wait();
                    }

                    int consumedValue = linkedList.removeFirst();
                    System.out.println("Consumed value " + consumedValue);
                    notify();
                    Thread.sleep(1000);
                    counter--;
                }
            }
        }
    }
}
