package homeWork.homeWork7.miningFarm;

import java.util.ArrayList;

public class GuildHall extends Thread {
    private Mine mine;
    private ArrayList<AllianceWorker> arrGH = new ArrayList<>();

    public GuildHall(Mine mine) {
        this.mine = mine;
        setDaemon(true);
        start();
    }

    @Override
    public void run() {
        int amount = 5;
        while (true) {
            try {
                Thread.sleep(5000);
                arrGH.add(new AllianceWorker(mine,"Крестьянин " + (amount+=1)));
                System.out.println("Ратуша создала кристьянина");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public ArrayList<AllianceWorker> getArrGH() {
        return arrGH;
    }

}
