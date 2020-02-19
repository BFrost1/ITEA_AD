package homeWork.homeWork8.musicalChairs;


import java.util.ArrayList;
import java.util.concurrent.CyclicBarrier;

public class Playroom implements Runnable {
    private Music music;
    private CyclicBarrier cb;
    private CyclicBarrier cb1;
    private ArrayList<Thread> arr = new ArrayList<>();


    public Playroom(Music music, int players) {
        this.music = music;
        cb = new CyclicBarrier(players, music);
        cb1 = new CyclicBarrier(players, this);
    }

    @Override
    public void run() {
        arr.get(arr.size() - 1).interrupt();
        System.out.println(arr.get(arr.size() - 1).getName() + " выбыл из игры");
        arr.remove(arr.size() - 1);
        System.out.println("Осталось стульев: " + (arr.size()-1));
        if (arr.size() != 1) {
            cb = new CyclicBarrier(arr.size(), music);
            cb1 = new CyclicBarrier(arr.size(), this);
            arr = new ArrayList<>();
        } else {
            System.out.println("Победитель: " + arr.get(0).getName());
            arr.get(0).interrupt();
        }
    }

    public CyclicBarrier getCb() {
        return cb;
    }

    public void setCb(CyclicBarrier cb) {
        this.cb = cb;
    }

    public ArrayList<Thread> getArr() {
        return arr;
    }

    public void setArr(ArrayList<Thread> arr) {
        this.arr = arr;
    }

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    public CyclicBarrier getCb1() {
        return cb1;
    }

    public void setCb1(CyclicBarrier cb1) {
        this.cb1 = cb1;
    }
}
