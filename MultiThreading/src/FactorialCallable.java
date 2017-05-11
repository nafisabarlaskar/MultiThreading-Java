import java.util.concurrent.Callable;

/**
 * Created by NafisaBarlaskar on 31-01-2017.
 */
public class FactorialCallable implements Callable<Long> {

    private int number;

    public FactorialCallable(int number){
        this.number = number;
    }

    public Long call() throws Exception{
        return factorial(number);
    }

    private long factorial(int number) throws InterruptedException {
        long result = number;
        while(number != 0 && (number-1) != 0){
            result *= (number-- - 1);
            Thread.sleep(100);
        }
        return result;
    }
}
