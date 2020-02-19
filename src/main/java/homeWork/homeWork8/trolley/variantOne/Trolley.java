package homeWork.homeWork8.trolley.variantOne;

public class Trolley {
    private int volume;
    private int loadedVolume;


    public Trolley(int volume) {
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getLoadedVolume() {
        return loadedVolume;
    }

    public void setLoadedVolume(int loadedVolume) {
        this.loadedVolume = loadedVolume;
    }
}
