package homeWork.homeWork7.superMarket;

import org.w3c.dom.ls.LSOutput;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class Cashier implements Runnable {
    private String name;
    private boolean open;


    public Cashier(String name) {
        this.name = name;
        new Thread(this).start();
    }

    @Override
    public synchronized void run() {
        while (!Thread.currentThread().isInterrupted() & !open) {
            try {
                wait(5000);
                if (new Random().nextInt(100) <= 30 & open) {
                    System.out.println("Херась! Метеорит расхреначил пол магазина");
                    Thread.currentThread().interrupt();
                    System.out.println("Кассир " + this.name + ": Касса закрылась! Валите все нахрен!");
                } else {
                    open = !open;
                    notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Кассир " + name + ": всё, я свалила!");
    }


    public synchronized void service(String nameBuyer) {
        try {
            if (open) {
                wait();
            }else {
                System.out.println("Кассир " + this.name + ": я обслуживаю покупателя " + nameBuyer);
                Thread.sleep((new Random().nextInt(2)+3)*1000);
                System.out.println("Кассир " + this.name + ": я закончила обслуживать покупателя " + nameBuyer);
                Thread.currentThread().interrupt();
                open = !open;
                notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

