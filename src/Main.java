import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CountDownLatch;
import java.util.Scanner;
import CustomClasses.Demo;

public class Main {
    public static boolean enemyNearby = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CountDownLatch latch = new CountDownLatch(2);

        // begin program
        System.out.println("main is starting...");
        System.out.println("Press enter to continue...");
        scanner.nextLine();

        // begin intro demo
        System.out.println("Here is a demonstration of the Java Thread class:");
        System.out.println("Press enter to start demo threads...");
        scanner.nextLine();

        // create introductory threads and start them
        Thread EnemySpawnThread = new Thread(()-> {
            try {
                Thread.sleep(10000);
                enemyNearby = true;
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted: " + e.getMessage());
                Thread.currentThread().interrupt();
                return;
            }
            latch.countDown();
        });

        Thread EnemyCheckThread = new Thread(()->{
            while(enemyNearby == false){
                System.out.println("No enemies nearby.");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("Thread was interrupted: " + e.getMessage());
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            System.out.println("1 Enemy Nearby.\n");
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted: " + e.getMessage());
                Thread.currentThread().interrupt();
                return;
            }
            latch.countDown();
        });

//        EnemySpawnThread.start();
//        EnemyCheckThread.start();

        // begin main demo (latch try-catch pauses main thread until initial demo threads are finished)
//        try {
//            latch.await();
//        } catch (InterruptedException e) {
//            System.out.println("Thread was interrupted: " + e.getMessage());
//        }

        System.out.println("Now let's begin the main demo!");
        System.out.println("Press enter to continue...");
        scanner.nextLine();

        // create Demo objects and array according to user specified size
        int arraySize = 1000000;
        Demo singleThreadedDemo = new Demo("Single Threaded Demo");
        Demo multiThreadedDemo = new Demo("Multi Threaded Demo");
        int[] array = generateArray(arraySize);
        long singleThreadedSum = 0;
        long multiThreadedSum = 0;

        // start threads and finish demo
        singleThreadedDemo.singleThreadedSum(array);

    }

    // method generates array
    public static int[] generateArray(int size) {
        int[] array = new int[size];

        Instant start = Instant.now();
        // randomly generate new array using for loop
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        Instant finish = Instant.now();

        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Array generated in: " + timeElapsed + " ms.");

        return array;
    }
}