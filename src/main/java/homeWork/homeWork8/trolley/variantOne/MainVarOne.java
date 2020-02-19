package homeWork.homeWork8.trolley.variantOne;

import java.util.concurrent.Exchanger;

// методом wait() and notify();

public class MainVarOne {
    public static void main(String[] args) {
        WarehouseOne warehouseOne = new WarehouseOne(10);
        WarehouseTwo warehouseTwo = new WarehouseTwo(0);

        Trolley trolley = new Trolley(6);

        Transporter transporter = new Transporter();
        Loader loader = new Loader(trolley,transporter,warehouseOne);
        Unloader unloader = new Unloader(transporter,warehouseTwo);
    }
}
