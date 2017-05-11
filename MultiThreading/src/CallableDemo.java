import java.util.concurrent.*;

/**
 * Created by NafisaBarlaskar on 31-01-2017.
 */
public class CallableDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService  executorService = Executors.newSingleThreadExecutor();

        System.out.println("Submitted callable task to compute the factorial of 10");
        Future result10 = executorService.submit(new FactorialCallable(10));

        System.out.println("Submitted callable task to compute the factorial of 15");
        Future result15 = executorService.submit(new FactorialCallable(15));

        System.out.println("Submitted callable task to compute the factorial of 20");
        Future result20 = executorService.submit(new FactorialCallable(20));

        System.out.println("Calling method of Future to get result of factorial 10");
        System.out.println("Factorial of 10: " + result10.get());

        System.out.println("Calling method of Future to get result of factorial 15");
        System.out.println("Factorial of 15: " + result15.get());

        System.out.println("Calling method of Future to get result of factorial 20");
        System.out.println("Factorial of 20: " + result20.get());
    }
}
