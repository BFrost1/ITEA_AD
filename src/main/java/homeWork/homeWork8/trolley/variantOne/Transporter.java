package homeWork.homeWork8.trolley.variantOne;

import java.util.concurrent.Exchanger;

public class Transporter extends Thread {
    private Loader loader;
    private Unloader unloader;
    private Trolley trolley;


    public Transporter() {
        setDaemon(true);
        start();
    }

    @Override
    public synchronized void run() {
        try {
            while (true) {
                wait();
                unloader.setTrolley(trolley);
                trolley = null;
                wait();
                loader.setTrolley(trolley);
                trolley = null;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void setTrolley(Trolley trolley) {
        this.trolley = trolley;
        notify();
    }

    public void setLoader(Loader loader) {
        this.loader = loader;
    }

    public void setUnloader(Unloader unloader) {
        this.unloader = unloader;
    }
}
