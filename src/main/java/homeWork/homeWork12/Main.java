package homeWork.homeWork12;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        Price price = (Price) new Mapper().getObject(new File("hotline.xml"), Price.class);
        System.out.println(price);
    }
}
