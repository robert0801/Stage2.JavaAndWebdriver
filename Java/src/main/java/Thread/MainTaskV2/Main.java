package Thread.MainTaskV2;

import Thread.MainTaskV2.parking.CarsCreator;
import Thread.MainTaskV2.parking.Parking;

public class Main {
    public static void main(String[] args) {
        CarsCreator carCreator = new CarsCreator(20);
        carCreator.start();
        new Parking(CarsCreator.listWithAllCars).start();
    }
}
