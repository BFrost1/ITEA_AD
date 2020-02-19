package homeWork.homeWork7.superMarket;

public class Buyer extends Thread {
    private String nameBuyer;
    private Cashier cashier;

    public Buyer(String name, Cashier cashier) {
        this.nameBuyer = name;
        this.cashier = cashier;
        setDaemon(true);
        start();
    }


    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            cashier.service(nameBuyer);
        }
        System.out.println("Покупатель " + nameBuyer + " вышел из магазина");
    }


}
