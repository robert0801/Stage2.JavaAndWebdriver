package Thread.MainTaskV1;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Car extends Thread {
    private String name;
    private Semaphore parkingPlace;

    public Car(String name, Semaphore semaphore) {
        this.name = name;
        this.parkingPlace = semaphore;
    }

    public String getNameCar() {
        return name;
    }

    @Override
    public void run() {
        System.out.println(this.getNameCar() + " arrived at the parking.");
        try {
            if (parkingPlace.availablePermits() == 0) {
                System.out.println(this.getNameCar() + " waits free parking place 10 sec.");
                TimeUnit.SECONDS.sleep(10);
                if (parkingPlace.availablePermits() == 0) {
                    System.out.println(this.getNameCar() + " don't finds the parking place and drives out.");
                    this.interrupt();
                } else {
                    this.stoppingOnParking();
                }
            } else {
                this.stoppingOnParking();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stoppingOnParking() {
        try {
            parkingPlace.acquire();
            System.out.println(this.getNameCar() + " stays at parking place 5 sec.");
            TimeUnit.SECONDS.sleep(5);
            System.out.println(this.getNameCar() + " drives out from parking и freedes up a parking place.");
            parkingPlace.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
