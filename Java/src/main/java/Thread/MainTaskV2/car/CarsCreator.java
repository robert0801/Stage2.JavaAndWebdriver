package Thread.MainTaskV2.car;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class CarsCreator extends Thread {
    public static LinkedBlockingDeque<Car> listWithAllCars = new LinkedBlockingDeque<>();
    public static int quantityOfCars;
    public static int quantityOfPlacesOnParking;


    public CarsCreator(int quantityOfCars, int quantityOfPlacesOnParking) {
        this.quantityOfCars = quantityOfCars;
        this.quantityOfPlacesOnParking = quantityOfPlacesOnParking;
    }

    @Override
    public void run() {
        for (int i = 0; i < quantityOfCars; i++) {
            Car car = new Car("Car #" + (i + 1));
            car.start();
            try {
                listWithAllCars.put(car);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
