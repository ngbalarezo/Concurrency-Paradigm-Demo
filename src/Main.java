import java.util.Scanner;
import CustomThreads.EnemyCheckThread;
import CustomThreads.EnemySpawnThread;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("main is starting...");
        System.out.println();
        System.out.println("Press enter to continue...");

        EnemySpawnThread enemy = new EnemySpawnThread("Werewolf John");

        Thread enemyCheck = new Thread(new EnemyCheckThread(), "Enemy Radar");


    }
}