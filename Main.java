public class Main {
    public static void main(String[] args) {
        final Shop shop = new Shop();
        final Factory factory = new Factory(shop);
        new Thread(null, shop::buyCar, "Покупатель 1").start();
        new Thread(null, shop::buyCar, "Покупатель 2").start();
        new Thread(null, shop::buyCar, "Покупатель 3").start();
        new Thread(null, factory::productions, "Завод").start();
    }
}
