package Thread.MainTaskV2;

import Thread.MainTaskV2.parking.CarsCreator;
import Thread.MainTaskV2.parking.Parking;

public class Main {
    public static void main(String[] args) {
        new CarsCreator(20).start();
        new Parking(CarsCreator.listWithAllCars).start();
    }
}
