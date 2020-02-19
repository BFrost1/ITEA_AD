package homeWork.homeWork8.trolley.variantOne;

import java.util.concurrent.Exchanger;

public class Loader extends Thread {
    private Trolley trolley;
    private Transporter transporter;
    private WarehouseOne warehouseOne;

    public Loader(Trolley trolley, Transporter transporter, WarehouseOne warehouseOne) {
        this.trolley = trolley;
        this.transporter = transporter;
        this.warehouseOne = warehouseOne;
        transporter.setLoader(this);
        start();
    }

    @Override
    public synchronized void run() {
        while (warehouseOne.getUranus() != 0 | trolley == null) {
            try {
                if (trolley != null) {
                    while (trolley.getLoadedVolume() != trolley.getVolume() & warehouseOne.getUranus() != 0) {
                        trolley.setLoadedVolume(trolley.getLoadedVolume() + warehouseOne.setUranus(1));
                        Thread.sleep(1000);
                        System.out.println("Погрузчик погрузил " + trolley.getLoadedVolume() + "кг урана");
                    }
                    System.out.println("Тележка полная " + trolley.getLoadedVolume() + "/" + trolley.getVolume());
                    System.out.println("Остаток на 1 складе " + warehouseOne.getUranus() + "кг урана");
                    transporter.setTrolley(trolley);
                    trolley = null;
                    System.out.println("Тележка передана транспортировщику");
                } else {
                    wait();
                    System.out.println("Погрузчик получил тележку");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Склад 1 пустой!");
        System.out.println("Все 'двинули кони' из-за радиации");
    }


    public synchronized void setTrolley(Trolley trolley) {
        this.trolley = trolley;
        notify();
    }
}
