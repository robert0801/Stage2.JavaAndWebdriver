package Thread.MainTaskV1.car;

import Thread.MainTaskV1.MainParking;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Car extends Thread {
    private String name;
    private Semaphore parkingPlace;
    private int parkingTime;
    private int waitingTime;
    private Random random = new Random();

    public Car(String name) {
        this.name = name;
        this.parkingPlace = MainParking.parkingPlace;
    }

    @Override
    public void run() {
        parkingTime = random.nextInt(10) + 1;
        waitingTime = random.nextInt(5) + 1;
        if (parkingPlace.availablePermits() == 0) {
            System.out.println(name + " waits free parking place.");
            checkAndWaitParkingPlace(1);
        } else {
            this.stoppingOnParking();
        }
    }

    private void stoppingOnParking() {
        try {
            parkingPlace.acquire();
            System.out.println(name + " stays at parking place and will be stay " + parkingTime + " sec. " +
                    "Left " + MainParking.parkingPlace.availablePermits() + " parking place.");
            TimeUnit.SECONDS.sleep(parkingTime);
            System.out.println(name + " drives out from parking and freedes up a parking place.");
            parkingPlace.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void checkAndWaitParkingPlace(int timeForCheck) {
        try {
            TimeUnit.SECONDS.sleep(timeForCheck);
            if (waitingTime == 0) {
                System.out.println(name + " don't finds the parking place and drives out.");
            } else if (parkingPlace.availablePermits() == 0) {
                waitingTime--;
                checkAndWaitParkingPlace(timeForCheck);
            } else stoppingOnParking();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
