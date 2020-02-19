package homeWork.homeWork8.musicalChairs;

import java.util.concurrent.BrokenBarrierException;

public class Player extends Thread {
    private Playroom playroom;

    public Player(Playroom playroom) {
        this.playroom = playroom;
        start();
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                System.out.println("Поток " + Thread.currentThread().getName() + " готов к участию");
                playroom.getCb().await();
                playroom.getArr().add(Thread.currentThread());
                playroom.getCb1().await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
