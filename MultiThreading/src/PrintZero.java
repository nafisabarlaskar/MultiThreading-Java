/**
 * Created by NafisaBarlaskar on 04-03-2017.
 */
public class PrintZero extends Thread{


    SequentialThreadPrint sequentialThreadPrint;
    public PrintZero(SequentialThreadPrint sequentialThreadPrint){
        this.sequentialThreadPrint = sequentialThreadPrint;
    }

    public void run(){
        try{
            synchronized (sequentialThreadPrint){
                for(int index = 0; index < 20; index++) {
                    while (SequentialThreadPrint.status != 0) {
                        sequentialThreadPrint.wait();
                    }
                    System.out.println("0");
                    SequentialThreadPrint.counter++;
                    if(SequentialThreadPrint.counter % 2 == 1){
                        SequentialThreadPrint.status = 1;
                    } else {
                        SequentialThreadPrint.status = 2;
                    }
                    sequentialThreadPrint.notifyAll();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
