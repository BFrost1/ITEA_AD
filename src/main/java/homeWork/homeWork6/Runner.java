package homeWork.homeWork6;

import java.util.Random;

public class Runner implements Runnable {
    private int step = 0;

    public Runner() {

    }

    @Override
    public void run() {
        while (step < 100) {
            try {
                step += new Random().nextInt(10);
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + " " + step);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
