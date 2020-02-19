package homeWork.homeWork8.musicalChairs;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Music extends Thread {
    private String muss;

    public Music(String muss) {
        this.muss = muss;
        start();
    }

    @Override
    public void run() {
        try {
            Player player = new Player(new FileInputStream(muss));
            player.play();
        } catch (JavaLayerException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getMuss() {
        return muss;
    }

    public void setMuss(String muss) {
        this.muss = muss;
    }
}
