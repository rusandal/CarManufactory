public class Factory {
    Shop shop;
    private static final int CAR_LIMIT = 10;
    private static final int TIME_PRODUCTION = 2000;

    public Factory(Shop shop) {
        this.shop = shop;
    }

    public void productions (){
        for(int i=1; i<=CAR_LIMIT; i++){
            try {
                Thread.sleep(TIME_PRODUCTION);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            shop.setCarsFromFactory();
        }
        System.out.println("Завод остановился");
    }

    public static int getCarLimit() {
        return CAR_LIMIT;
    }
}


