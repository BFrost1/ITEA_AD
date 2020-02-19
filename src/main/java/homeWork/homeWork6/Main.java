package homeWork.homeWork6;


public class Main {
    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runner());
        Thread thread2 = new Thread(new Runner());
        thread1.start();
        thread2.start();

        while (thread1.isAlive() & thread2.isAlive()) {}
        System.out.println(thread1.isAlive() ? "Поток 1 выиграл" : "Поток 0 выиграл");
    }
}
