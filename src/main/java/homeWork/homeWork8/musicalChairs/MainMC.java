package homeWork.homeWork8.musicalChairs;


import javazoom.jl.decoder.JavaLayerException;


import java.io.FileNotFoundException;


public class MainMC {
    public static void main(String[] args) throws FileNotFoundException, JavaLayerException {
        Playroom playroom = new Playroom(new Music("src/main/music/song.mp3"), 5);
        for (int i = 0; i < 5; i++) {
            new Player(playroom);
        }


    }
}
