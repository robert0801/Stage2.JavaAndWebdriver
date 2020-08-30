package Thread.MainTaskV2.parking;

import Thread.MainTaskV2.car.Car;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class CarsCreator extends Thread {
    public static LinkedBlockingDeque<Car> listWithAllCars = new LinkedBlockingDeque<>();
    private int quantityOfCars;

    public CarsCreator(int quantityOfCars) {
        this.quantityOfCars = quantityOfCars;
    }

    @Override
    public void run() {
        for (int i = 0; i < quantityOfCars; i++) {
            Car car = new Car(i + 1);
            car.run();
            try {
                listWithAllCars.add(car);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
