package homeWork.homeWork8.trolley.variantOne;

public class WarehouseOne {
    private int uranus;

    public WarehouseOne(int uranus) {
        this.uranus = uranus;
    }

    public int getUranus() {
        return uranus;
    }

    public int setUranus(int uranus) {
        this.uranus -= uranus;
        return uranus;
    }
}
