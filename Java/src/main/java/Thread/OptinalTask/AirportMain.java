package Thread.OptinalTask;

import java.util.concurrent.Semaphore;

public class AirportMain {
    public static void main(String[] args) throws InterruptedException {
        Semaphore subway = new Semaphore(5);
        for (int i = 1; i <= 10; i++) {
            new Plane(subway, "Plane №" + i).start();
        }
    }
}
