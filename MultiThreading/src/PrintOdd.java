/**
 * Created by NafisaBarlaskar on 04-03-2017.
 */
public class PrintOdd extends Thread{

    SequentialThreadPrint sequentialThreadPrint;
    public PrintOdd(SequentialThreadPrint sequentialThreadPrint){
        this.sequentialThreadPrint = sequentialThreadPrint;
    }
    public void run(){
        try{
            synchronized (sequentialThreadPrint){
                for(int index = 0; index < 20; index++) {
                    while (SequentialThreadPrint.status != 1) {
                        sequentialThreadPrint.wait();
                    }
                    if (SequentialThreadPrint.counter % 2 == 1) {
                        System.out.println(SequentialThreadPrint.counter);
                    }
                    SequentialThreadPrint.status = 0;
                    sequentialThreadPrint.notifyAll();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
