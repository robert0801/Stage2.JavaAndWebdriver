package Thread.MainTaskV2.parking;

import Thread.MainTaskV2.car.Car;

import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Parking extends Thread {
    private static final int QUANTITY_OF_PARKING_PLACES = 5;
    private LinkedBlockingDeque<Car> carsThatStayOnParkingPlace = new LinkedBlockingDeque<>();
    private LinkedBlockingDeque<Car> carsThatWaitingParkingPlace = new LinkedBlockingDeque<>();
    private int quantityOfFreePlaces = QUANTITY_OF_PARKING_PLACES;

    public Parking(LinkedBlockingDeque<Car> allCars) {
        carsThatWaitingParkingPlace.addAll(allCars);
        try {
            this.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (CarsCreator.listWithAllCars.isEmpty()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
        while (!CarsCreator.listWithAllCars.isEmpty() || carsThatWaitingParkingPlace.size() > 0) {
            if (!CarsCreator.listWithAllCars.isEmpty()) {
                carsThatWaitingParkingPlace.add(CarsCreator.listWithAllCars.getFirst());
                getParkingPlace(carsThatWaitingParkingPlace.getFirst());
                CarsCreator.listWithAllCars.removeFirst();
            }
            else if (carsThatWaitingParkingPlace.size() > 0) {
                getParkingPlace(carsThatWaitingParkingPlace.getFirst());
            }
        }
    }

    public void getParkingPlace(Car carThread) {
        if (quantityOfFreePlaces > 0) {
            carsThatStayOnParkingPlace.add(carThread);
            quantityOfFreePlaces--;
            if (quantityOfFreePlaces >= 1) {
                System.out.println("Car #" + carThread.getCarID() + " parking at "
                        + carThread.getParkingTime() + " minutes. Left " + quantityOfFreePlaces + " free parking places.");
            } else {
                System.out.println("Car #" + carThread.getCarID()
                        + " parking at " + carThread.getParkingTime() + " minutes. " +
                        "There are not free parking places at that moment.");
            }
            carsThatWaitingParkingPlace.remove(carThread);
            waitAndReleaseCar(1);
        } else {
            waitAndReleaseCar(1);
            if (quantityOfFreePlaces == 0) {
                Iterator<Car> carThreadIterator = carsThatWaitingParkingPlace.iterator();
                while (carThreadIterator.hasNext()) {
                    Car currentCarThread = carThreadIterator.next();
                    if (currentCarThread.getWaitingTime() <= 0) {
                        System.out.println("Car #" + carThread.getCarID()
                                + " don't waits the parking place and drives out.");
                        carsThatWaitingParkingPlace.remove(currentCarThread);
                    }
                }
            }

            if (quantityOfFreePlaces > 0) {
                carsThatStayOnParkingPlace.add(carThread);
                quantityOfFreePlaces--;
                System.out.println("Car #" + carThread.getCarID()
                        + " parking at " + carThread.getParkingTime() + " minutes. Left "
                        + quantityOfFreePlaces + " free parking places.");
                carsThatWaitingParkingPlace.remove(carThread);
            }
        }
    }

    public void waitAndReleaseCar(int time) {
        try {
            TimeUnit.SECONDS.sleep(time);
            carReleaseWithOutParking();
            carReleaseAfterParking();
        } catch (InterruptedException e) {
        }
    }

    public void carReleaseAfterParking() {
        Iterator<Car> carThreadIterator = carsThatStayOnParkingPlace.iterator();
        while (carThreadIterator.hasNext()) {
            Car currentCarThread = carThreadIterator.next();
            currentCarThread.setParkingTime(currentCarThread.getParkingTime() - 1);
            if (currentCarThread.getParkingTime() <= 0) {
                System.out.println("Car #" + currentCarThread.getCarID()
                        + " drove after parking.");
                carsThatStayOnParkingPlace.remove(currentCarThread);
                quantityOfFreePlaces++;
            }
        }
    }

    public void carReleaseWithOutParking() {
        Iterator<Car> carThreadIterator = carsThatWaitingParkingPlace.iterator();
        while (carThreadIterator.hasNext()) {
            Car currentCarThread = carThreadIterator.next();
            currentCarThread.setWaitingTime(currentCarThread.getWaitingTime() - 1);
        }
    }


}
