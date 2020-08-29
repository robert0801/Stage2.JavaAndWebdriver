package Thread.OptinalTask;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Plane extends Thread {
    private Semaphore runway;
    private String namePlane;

    public Plane(Semaphore runway, String namePlane) throws InterruptedException {
        this.runway = runway;
        this.namePlane = namePlane;
        this.join();
    }

    public String getNamePlane() {
        return namePlane;
    }

    @Override
    public void run() {
        try {
            runway.acquire();
            System.out.println(this.getNamePlane() + " entered the runway.");
            TimeUnit.SECONDS.sleep(3);
            System.out.println("The runway \"take\" the " + this.getNamePlane());
            TimeUnit.SECONDS.sleep(3);
            System.out.println(this.getNamePlane() + " took off.");
            TimeUnit.SECONDS.sleep(3);
            System.out.println("The runway is free.");
            runway.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
