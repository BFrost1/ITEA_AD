package homeWork.homeWork8.trolley.variantTwo;

import java.util.concurrent.Exchanger;

// методом Exchanger<V>

public class MainVarTwo {
    public static void main(String[] args) {
        Exchanger exchangerLoaderEransporter = new Exchanger();
        Exchanger exchangerEransporterUnloader = new Exchanger();

        WarehouseOne warehouseOne = new WarehouseOne(10);
        WarehouseTwo warehouseTwo = new WarehouseTwo(0);

        Trolley trolley = new Trolley(6);
        new Loader(exchangerLoaderEransporter, trolley, warehouseOne);
        new Transporter(exchangerLoaderEransporter,exchangerEransporterUnloader);
        new Unloader(exchangerEransporterUnloader,warehouseTwo);
    }
}
