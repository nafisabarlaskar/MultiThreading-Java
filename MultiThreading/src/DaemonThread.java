import javafx.concurrent.Task;

/**
 * Created by NafisaBarlaskar on 30-01-2017.
 */
public class DaemonThread {

    public static void main(String[] args){

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread name: " + Thread.currentThread().getName());
            }
        });
        thread.setDaemon(true);
        thread.start();
        System.out.println("Daemon Thread: " + thread.isDaemon());

    }
}
