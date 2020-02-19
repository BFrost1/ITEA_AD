package homeWork.homeWork7.miningFarm;

import homeWork.homeWork2.guide.Guidebook;
import org.w3c.dom.ls.LSOutput;

import java.awt.event.ActionListener;
import java.util.*;

public class MainMF {
    public static void main(String[] args) {
        Mine mine = new Mine(100);
        ArrayList<AllianceWorker> arr = new ArrayList<>();

        for (int i = 1; i <= 5; i++ )
            arr.add(new AllianceWorker(mine, "Крестьянин " + i));

        GuildHall guildHall = new GuildHall(mine);
        while (mine.getGold()!=0){}
        arr.addAll(guildHall.getArrGH());
        arr.sort(Comparator.comparing(AllianceWorker::getGold));
        System.out.println("Победитель " + arr.get(arr.size() - 1).toString());
    }
}
