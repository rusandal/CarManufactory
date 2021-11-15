public class Main {
    public static void main(String[] args) {
        final Manufacturer manufacturer = new Manufacturer();

        new Thread(null, manufacturer::buyCar, "Покупатель 1").start();
        new Thread(null, manufacturer::buyCar, "Покупатель 2").start();
        new Thread(null, manufacturer::buyCar, "Покупатель 3").start();
        new Thread(null, manufacturer::productionCar, "Завод").start();

    }
}
