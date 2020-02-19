package homeWork.homeWork8.trolley.variantOne;

import java.util.concurrent.Exchanger;

public class Unloader extends Thread {
    private Transporter transporter;
    private Trolley trolley;
    private WarehouseTwo warehouseTwo;

    public Unloader(Transporter transporter, WarehouseTwo warehouseTwo) {
        this.transporter = transporter;
        this.warehouseTwo = warehouseTwo;
        transporter.setUnloader(this);
        setDaemon(true);
        start();
    }

    @Override
    public synchronized void run() {
        while (true) {
            try {
                if (trolley != null) {
                    while (trolley.getLoadedVolume() != 0) {
                        trolley.setLoadedVolume(trolley.getLoadedVolume() - 1);
                        System.out.println("Тележка разгружена на " + trolley.getLoadedVolume() + "/" + trolley.getVolume());
                        warehouseTwo.setUranus(1);
                        Thread.sleep(1000);
                    }
                    System.out.println("Тележка пуста " + trolley.getLoadedVolume() + "/" + trolley.getVolume());
                    System.out.println("Остаток на 2 складе " + warehouseTwo.getUranus() + "кг урана");
                    transporter.setTrolley(trolley);
                    trolley = null;
                    System.out.println("Тележка передана транспортировщику на новую погрузку");
                } else {
                    wait();
                    System.out.println("Разгрузчик получил тележку и начал разгружать на 2 склад");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void setTrolley(Trolley trolley) {
        this.trolley = trolley;
        notify();
    }
}

