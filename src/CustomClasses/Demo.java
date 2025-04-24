package CustomClasses;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.List;
import java.util.ArrayList;

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
        System.out.println(this.demoName + ": sum = : " + sum.get() + "\n");
    }

    public void multiThreadedSum(int[] array) {
        int threadCount = 4;
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        int arrayPortionSize = array.length/threadCount;
        List<Future<Long>> futures = new ArrayList<>();

        // create tasks


        // timer start, thread start, and calculate timeElapsed
        Instant start = Instant.now();

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();

        // print results
        System.out.println(this.demoName + ": sum of array calculated in: " + timeElapsed + " ms.");
        System.out.println(this.demoName + ": sum = : " + finalSum);
    }

}
