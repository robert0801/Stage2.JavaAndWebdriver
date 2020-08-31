package Thread.MainTaskV2.car;

import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

import static Thread.MainTaskV2.car.CarsCreator.listWithAllCars;
import static Thread.MainTaskV2.car.CarsCreator.quantityOfPlacesOnParking;


public class Car extends Thread {
    private static int quantityOfFreePlaces = quantityOfPlacesOnParking;
    private static BlockingDeque<Car> carsThatStayOnParkingPlace
            = new LinkedBlockingDeque<>(quantityOfPlacesOnParking);
    private String name;
    private int parkingTime;
    private double waitingTime;
    private Random random = new Random();

    public Car(String name) {
        this.name = name;
        this.waitingTime = random.nextInt(5) + 1;
        this.parkingTime = random.nextInt(10) + 1;
    }

    @Override
    public void run() {
        try {
            listWithAllCars.take();
            if (quantityOfFreePlaces > 0) {
                stoppingOnParking(this);
            } else {
                System.out.println(name + " drives at parking. There is not free parking place and "
                        + name + " will be wait parking place " + waitingTime + " sec.");
                checkAndWaitParkingPlace(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void checkAndWaitParkingPlace(int timeForChecking) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(timeForChecking);
        if (waitingTime <= 0) {
            System.out.println(name + " don't finds the parking place and drives out.");
        } else if (quantityOfFreePlaces == 0) {
            waitingTime -= (double) timeForChecking / 1000;
            checkAndWaitParkingPlace(timeForChecking);
        } else stoppingOnParking(this);
    }

    private void stoppingOnParking(Car car) {
        try {
            carsThatStayOnParkingPlace.put(car);
            quantityOfFreePlaces--;
            System.out.println(name + " stays at parking place and will be stay " + parkingTime + " sec. " +
                    "Left " + quantityOfFreePlaces + " parking place.");
            TimeUnit.SECONDS.sleep(parkingTime);
            quantityOfFreePlaces++;
            System.out.println(name + " drives out from parking and freedes up a parking place. " +
                    quantityOfFreePlaces + " parking place is free.");
            carsThatStayOnParkingPlace.remove(car);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getParkingTime() {
        return parkingTime;
    }

    public void setParkingTime(int parkingTime) {
        this.parkingTime = parkingTime;
    }

    public double getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    @Override
    public String toString() {
        return "CarThread{" +
                "with name ='" + name + '\'' +
                '}';
    }
}
