/**
 * Created by NafisaBarlaskar on 04-03-2017.
 */
public class SequentialThreadPrint {

    public static int status = 0;
    public static int counter = 0;
    public static void main(String[] args){

        SequentialThreadPrint sequentialThreadPrint = new SequentialThreadPrint();
        PrintZero printZero = new PrintZero(sequentialThreadPrint);
        PrintEven printEven = new PrintEven(sequentialThreadPrint);
        PrintOdd printOdd = new PrintOdd(sequentialThreadPrint);

        printZero.start();
        printOdd.start();
        printEven.start();


    }
}
