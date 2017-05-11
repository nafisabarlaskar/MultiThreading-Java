/**
 * Created by NafisaBarlaskar on 04-03-2017.
 */
public class PrintEven extends Thread {

       SequentialThreadPrint sequentialThreadPrint;
       public PrintEven(SequentialThreadPrint sequentialThreadPrint){
           this.sequentialThreadPrint = sequentialThreadPrint;
       }
       public void run(){
           try{
               synchronized (sequentialThreadPrint){
                   for(int index = 0; index < 20; index++) {
                       while (SequentialThreadPrint.status != 2) {
                           sequentialThreadPrint.wait();
                       }
                       if (SequentialThreadPrint.counter % 2 == 0) {
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
