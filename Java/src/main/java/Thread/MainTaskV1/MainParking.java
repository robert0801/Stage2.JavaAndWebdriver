/*Автостоянка. Доступно несколько машиномест. На одном месте может находиться только один автомобиль.
Если все места заняты, то автомобиль не станет ждать больше определенного времени и уедет на другую стоянку.*/

package Thread.MainTaskV1;

import java.util.concurrent.Semaphore;

public class MainParking {
    public static void main(String[] args) {
        Semaphore parkingPlace = new Semaphore(3);

        Car car1 = new Car("Vasya", parkingPlace);
        Car car2 = new Car("Kostya", parkingPlace);
        Car car3 = new Car("Petya", parkingPlace);
        Car car4 = new Car("Igor", parkingPlace);
        Car car5 = new Car("Ivan", parkingPlace);
        Car car6 = new Car("Oleg", parkingPlace);
        Car car7 = new Car("Vika", parkingPlace);
        Car car8 = new Car("Olya", parkingPlace);
        Car car9 = new Car("Anna", parkingPlace);
        Car car10 = new Car("Lena", parkingPlace);

        car1.start();
        car2.start();
        car3.start();
        car4.start();
        car5.start();
        car6.start();
        car7.start();
        car8.start();
        car9.start();
        car10.start();

    }
}

