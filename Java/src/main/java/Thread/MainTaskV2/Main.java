package Thread.MainTaskV2;

import Thread.MainTaskV2.car.CarsCreator;

public class Main {
    public static void main(String[] args) {
        CarsCreator carsCreator = new CarsCreator(20, 3);
        carsCreator.start();
    }
}
