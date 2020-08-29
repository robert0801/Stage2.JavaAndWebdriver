package Thread.MainTaskV2.car;


import Thread.MainTaskV2.parking.CarsCreator;

import java.util.Random;

public class Car extends Thread {
    private int carID;
    private int parkingTime;
    private int waitingTime;
    private Random random = new Random();

    @Override
    public void run() {
        this.waitingTime = random.nextInt(10) + 1;
        this.parkingTime = random.nextInt(10) + 1;
        this.carID = CarsCreator.carID++;
    }

    public int getCarID() {
        return carID;
    }

    public int getParkingTime() {
        return parkingTime;
    }

    public void setParkingTime(int parkingTime) {
        this.parkingTime = parkingTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    @Override
    public String toString() {
        return "CarThread{" +
                "with id ='" + carID + '\'' +
                '}';
    }
}
