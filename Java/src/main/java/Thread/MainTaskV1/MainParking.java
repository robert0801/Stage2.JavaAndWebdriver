/*Автостоянка. Доступно несколько машиномест. На одном месте может находиться только один автомобиль.
Если все места заняты, то автомобиль не станет ждать больше определенного времени и уедет на другую стоянку.*/

package Thread.MainTaskV1;

import Thread.MainTaskV1.car.CarCreator;

import java.util.concurrent.Semaphore;

public class MainParking {
    public static Semaphore parkingPlace = new Semaphore(3);

    public static void main(String[] args) {
        CarCreator carCreator = new CarCreator(20);
        carCreator.start();
    }
}

