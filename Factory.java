public class Factory {
   Shop shop;
    private static int carLimit = 10;
    private static int timeProduction = 2000;

    public Factory(Shop shop) {
        this.shop = shop;
    }

    public synchronized void productions (){
        for(int i=1; i<=carLimit; i++){
            try {
                Thread.sleep(timeProduction);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            shop.setCarsFromFactory();
        }
        System.out.println("Завод остановился");
    }

    public static int getCarLimit() {
        return carLimit;
    }
}
