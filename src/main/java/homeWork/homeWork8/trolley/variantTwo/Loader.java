package homeWork.homeWork8.trolley.variantTwo;

import java.sql.SQLOutput;
import java.util.concurrent.Exchanger;

public class Loader extends Thread {
    private Exchanger<Trolley> exchangerLoaderTransporter;
    private Trolley trolley;
    private WarehouseOne warehouseOne;

    public Loader(Exchanger<Trolley> exchangerLoaderTransporter, Trolley trolley, WarehouseOne warehouseOne) {
        this.exchangerLoaderTransporter = exchangerLoaderTransporter;
        this.trolley = trolley;
        this.warehouseOne = warehouseOne;
        start();
    }

    @Override
    public void run() {
        while (warehouseOne.getUranus() != 0 | trolley == null) {
            try {
                if (trolley != null) {
                    System.out.println("Погрузчик начал наполнять тележку");
                    while (trolley.getLoadedVolume() != trolley.getVolume() & warehouseOne.getUranus() != 0) {
                        trolley.setLoadedVolume(trolley.getLoadedVolume() + warehouseOne.setUranus(1));
                        Thread.sleep(1000);
                        System.out.println("Погрузчик погрузил " + trolley.getLoadedVolume() + "кг урана");
                    }
                    System.out.println("Тележка полная " + trolley.getLoadedVolume() + "/" + trolley.getVolume());
                    System.out.println("Остаток на 1 складе " + warehouseOne.getUranus() + "кг урана");
                    trolley = exchangerLoaderTransporter.exchange(trolley);
                    System.out.println("Тележка передана транспортировщику");
                } else {
                    trolley = exchangerLoaderTransporter.exchange(null);
                    System.out.println("Погрузчик получил тележку");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Склад 1 пустой!");
        System.out.println("Все 'двинули кони' из-за радиации");

    }
}
