package homeWork.homeWork9.typesСats;

public class MainCats {
    public static void main(String[] args) {
        Cat cat = new Cat("Cat", "black", 1);
        FatCat fatCat = new FatCat("FatCat", "pink", 2);
        HomelessCat homelessCat = new HomelessCat("HomelessCat", "blue", 3);
        Class[] cats = new Class[] {cat.getClass(), fatCat.getClass(), homelessCat.getClass()};
        CatFactory factory = new CatFactory(cats);
    }
}
