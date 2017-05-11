import java.util.concurrent.TimeUnit;

/**
 * Created by NafisaBarlaskar on 28-01-2017.
 */
public class StopThread {

    private static boolean stopRequested;

    public static void main(String[] args) throws InterruptedException{

        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int index = 0;
                while(!stopRequested){
                    System.out.println(index);
                    index++;
                }
            }
        });

        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;

    }
}
