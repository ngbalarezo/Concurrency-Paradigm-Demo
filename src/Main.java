import java.util.Scanner;

public class Main {
    public static boolean enemyNearby = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
            System.out.println("1 Enemy Nearby.");
        });

        EnemySpawnThread.start();
        EnemyCheckThread.start();

    }
}