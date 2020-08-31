package Thread.MainTaskV1.car;


import java.util.concurrent.TimeUnit;

public class CarCreator extends Thread {
    private int quantityOfCars;


    public CarCreator(int quantityOfCars) {
        this.quantityOfCars = quantityOfCars;
    }

    @Override
    public void run() {
        for (int i = 0; i < quantityOfCars; i++) {
            Car car = new Car("Car #" + (i + 1));
            car.start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
