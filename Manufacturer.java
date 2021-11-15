import java.util.ArrayList;
import java.util.List;

public class Manufacturer {

    private static final int waiting = 3000;
    private static final int productCarWaiting = 2000;
    private static List<Car> cars = new ArrayList<>();
    private static final int maxCarCount = 9;


    public static List<Car> getCars() {
        return cars;
    }

    public synchronized void setCars(Car car) {
        cars.add(car);
        notify();
        System.out.println("Машина произведена");
    }

    public void productionCar() {
        while (maxCarCount >= getCars().size()) {
            try {
                Thread.sleep(productCarWaiting);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setCars(new Car());
        }
    }

    public void buyCar() {
        while (maxCarCount > getCars().size()){
            synchronized (this){
                try {
                    System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
                    System.out.println("Машин нет");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");
            try {
                Thread.sleep(waiting);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
