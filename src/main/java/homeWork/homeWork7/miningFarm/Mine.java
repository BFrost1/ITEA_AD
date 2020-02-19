package homeWork.homeWork7.miningFarm;

public class Mine {
    private volatile int gold;

    public Mine(int gold) {
        this.gold = gold;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
