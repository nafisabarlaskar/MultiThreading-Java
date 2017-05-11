/**
 * Created by NafisaBarlaskar on 30-01-2017.
 */
public class MultipleThread {

    public static void main(String[] args){

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 2; i++){
                    System.out.println("This is the first thread: " + Thread.currentThread().getName());
                }
            }
        }, "Thread1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 2; i++){
                    System.out.println("This is the second thread: " + Thread.currentThread().getName());
                }
            }
        }, "Thread2");

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 2; i++){
                    System.out.println("This is the third thread: " + Thread.currentThread().getName());
                }
            }
        }, "Thread3");

        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 2; i++){
                    System.out.println("This is the fourth thread: " + Thread.currentThread().getName());
                }
            }
        }, "Thread4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.run();

        try{
            thread3.join();
            thread2.join();
            thread1.join();
        }catch (InterruptedException e){
            System.out.println(e);
        }

    }
}
