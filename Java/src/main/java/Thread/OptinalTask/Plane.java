package Thread.OptinalTask;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Plane extends Thread {
    private Semaphore runway;
    private String namePlane;

    public Plane(Semaphore runway, String namePlane) {
        this.runway = runway;
        this.namePlane = namePlane;
    }

    public String getNamePlane() {
        return namePlane;
    }

    @Override
    public void run() {
        try {
            runway.acquire();
            System.out.println(this.getNamePlane() + " entered the runway.");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("The runway \"take\" the " + this.getNamePlane() +
                    " and the plane started to take off.");
            TimeUnit.SECONDS.sleep(1);
            System.out.println(this.getNamePlane() + " took off.");
            System.out.println("The runway is free.");
            TimeUnit.SECONDS.sleep(1);
            runway.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
