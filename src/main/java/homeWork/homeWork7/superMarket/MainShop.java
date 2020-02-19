package homeWork.homeWork7.superMarket;

import homeWork.homeWork7.superMarket.Buyer;
import homeWork.homeWork7.superMarket.Cashier;

public class MainShop {
    public static void main(String[] args) {
        Cashier cashier = new Cashier("Галя");
        new Buyer("Вася", cashier);
        new Buyer("Петя", cashier);
        new Buyer("Люся", cashier);
        new Buyer("Варвара", cashier);
        new Buyer("Светозар", cashier);
    }
}
