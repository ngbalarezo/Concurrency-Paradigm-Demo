package CustomClasses;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Demo {
    public String demoName;

    // constructor
    public Demo(String demoName) {
        this.demoName = demoName;
    }

    // method sums array elements using a single thread
    public void singleThreadedSum(int[] array) {
        // create AtomicInteger and single thread
        AtomicLong sum = new AtomicLong();
        Thread summationThread = new Thread(()-> {
            for (int i = 0; i < array.length; i++) {
                sum.addAndGet(array[i]);
            }
        });

        // timer start, thread start, and calculate timeElapsed
        Instant start = Instant.now();
        summationThread.start();
        try {
            summationThread.join();
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
            return;
        }
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();

        // print results
        System.out.println(this.demoName + ": sum of array calculated in: " + timeElapsed + " ms.");
        System.out.println(this.demoName + ": sum = : " + sum.get());
    }

    public int multiThreadedSum(int[] array) {
        return 0;
    }

}
