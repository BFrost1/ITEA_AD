package homeWork.homeWork1.converter;

import homeWork.homeWork1.shellHeroes.Hero;

import java.io.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class ConverterBin {

    public static void converterHeroBin(Hero hero){
        ResourceBundle bundle = ResourceBundle.getBundle("messagebundle", new Locale("en", "US"));
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("src/" + bundle.getString("name") + ".bin"))) {
            dos.writeUTF(hero.getName());
            dos.writeUTF(hero.getReplicaOne());
            dos.writeUTF(hero.getReplicaTwo());
            dos.writeUTF(hero.getReplicaThree());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Hero converterHeroObject(String name) throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream("src/" + name + ".bin"));
        Hero hero = new Hero(dis.readUTF(), dis.readUTF(), dis.readUTF(), dis.readUTF());
        return hero;
    }
}
