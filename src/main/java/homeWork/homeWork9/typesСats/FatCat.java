package homeWork.homeWork9.typesСats;

import homeWork.homeWork9.annotations.Blochable;
import homeWork.homeWork9.annotations.LuckyCat;
import homeWork.homeWork9.annotations.Paw;

@Blochable
public class FatCat extends Animal {
    @LuckyCat( lucky = false)
    private String name;
    private String color;
    private int age;


    public FatCat(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }
    @Paw(amount = 2)
    @Override
    public void vote() {
        System.out.println("Толстий кот мяукает");
    }

    @Override
    public String toString() {
        return "FatCat{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
