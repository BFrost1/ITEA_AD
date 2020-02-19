package homeWork.homeWork9.typesСats;

import homeWork.homeWork9.annotations.LuckyCat;
import homeWork.homeWork9.annotations.Paw;

public class HomelessCat extends Animal {
    @LuckyCat( lucky = false)
    private String name;
    private String color;
    private int age;


    public HomelessCat(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    @Paw(amount = 3)
    @Override
    public void vote() {
        System.out.println("Бездомный кот мяукает");
    }

    @Override
    public String toString() {
        return "HomelessCat{" +
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
