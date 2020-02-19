package homeWork.homeWork8.trolley.variantTwo;

import java.util.concurrent.Exchanger;

public class Unloader extends Thread {
    private Exchanger<Trolley> exchangerTransporterUnloader;
    private Trolley trolley;
    private WarehouseTwo warehouseTwo;

    public Unloader(Exchanger<Trolley> exchangerTransporterUnloader, WarehouseTwo warehouseTwo) {
        this.exchangerTransporterUnloader = exchangerTransporterUnloader;
        this.warehouseTwo = warehouseTwo;
        setDaemon(true);
        start();
    }

    @Override
    public void run() {
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
                    trolley = exchangerTransporterUnloader.exchange(trolley);
                    System.out.println("Тележка передана транспортировщику на новую погрузку");
                } else {
                    trolley = exchangerTransporterUnloader.exchange(null);
                    System.out.println("Разгрузчик получил тележку и начал разгружать на 2 склад");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

