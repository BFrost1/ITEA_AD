package homeWork.homeWork7.miningFarm;

import java.util.Objects;
import java.util.Random;

public class AllianceWorker extends Thread {
    private String name;
    private int step = 3;
    private Mine mine;
    private int gold;

    public AllianceWorker(Mine mine, String name) {
        this.mine = mine;
        this.name = name;
        start();
    }


    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (mine) {
                if (mine.getGold() - step > 0) {
                    mine.setGold(mine.getGold() - step);
                    gold += step;
                    System.out.println(name + " я добыл " + gold);
                } else {
                    gold += mine.getGold();
                    mine.setGold(0);
                    System.out.println(name + " ВСЕГО ДОБЫЛ ЗОЛОТА: " + gold);
                    name =  Thread.currentThread().getName();
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    @Override
    public String toString() {
        return name + ": " + gold;
    }

    public Mine getMine() {
        return mine;
    }

    public void setMine(Mine mine) {
        this.mine = mine;
    }

    public int getGold() {
        return gold;
    }


}
