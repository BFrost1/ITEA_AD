package homeWork.homeWork9.typesСats;

import homeWork.homeWork9.annotations.Blochable;
import homeWork.homeWork9.annotations.LuckyCat;
import homeWork.homeWork9.annotations.Paw;

public class Cat extends Animal {
    @LuckyCat(lucky = true)
    private String name;
    private String color;
    private int age;


    public Cat(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }
    @Paw()
    @Override
    public void vote() {
        System.out.println("Обычный кот мяукает");
    }

    @Override
    public String toString() {
        return "Car{" +
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
