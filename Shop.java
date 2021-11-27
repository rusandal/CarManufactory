import java.util.ArrayList;
import java.util.List;

public class Shop {
    private static final int buyerSleep = 5000;
    protected static List<Car> allCarFromFactory = new ArrayList<>();
    private static int buyCountCars = 0;

    public void buyCar() {
        while (buyCountCars <= Factory.getCarLimit()) {
            synchronized (this) {
                    while (allCarFromFactory.isEmpty() & buyCountCars < Factory.getCarLimit()) {
                        System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
                        System.out.println("Машин нет");
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (buyCountCars == Factory.getCarLimit()) {
                        System.out.println("Машин не будет, завод остановился");
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");
                    allCarFromFactory.remove(0);
                    buyCountCars++;
            }
            try {
                Thread.sleep(buyerSleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void setCarsFromFactory() {
        allCarFromFactory.add(new Car());
        System.out.println("Производитель Toyota выпустил 1 авто");
        notifyAll();
    }
}
