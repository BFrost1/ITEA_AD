package homeWork.homeWork8.trolley.variantTwo;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Transporter extends Thread {
    private Exchanger<Trolley> exchangerLoaderTransporter;
    private Exchanger<Trolley> exchangerTransporterUnloader;
    private Trolley trolley;


    public Transporter(Exchanger<Trolley> exchangerLoaderTransporter, Exchanger<Trolley> exchangerTransporterUnloader) {
        this.exchangerLoaderTransporter = exchangerLoaderTransporter;
        this.exchangerTransporterUnloader = exchangerTransporterUnloader;
        setDaemon(true);
        start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                exchangerTransporterUnloader.exchange(exchangerLoaderTransporter.exchange(null));
                System.out.println("Транспортировщик принимает полную тележку и передает ее разгрузчику");
                exchangerLoaderTransporter.exchange(exchangerTransporterUnloader.exchange(null));
                System.out.println("Транспортировщик принимает пустую тележку и передает ее погрузчику");
            }
        } catch (InterruptedException e) {
            isInterrupted();
        }
    }
}
