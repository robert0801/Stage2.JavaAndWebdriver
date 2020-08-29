package Thread.MainTaskV2.parking;

import Thread.MainTaskV2.car.Car;

import java.util.concurrent.LinkedBlockingDeque;

public class CarsCreator extends Thread {
    public static LinkedBlockingDeque<Car> listWithAllCars = new LinkedBlockingDeque<>();
    public static int carID = 1;
    private int quantityOfCars;

    public CarsCreator(int quantityOfCars) {
        this.quantityOfCars = quantityOfCars;
    }

    @Override
    public void run() {
        for (int i = 0; i < quantityOfCars; i++) {
            Car car = new Car();
            car.run();
            listWithAllCars.offer(car);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
