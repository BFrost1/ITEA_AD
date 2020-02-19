package homeWork.homeWork1;

import homeWork.homeWork1.converter.ConverterBin;
import homeWork.homeWork1.shellHeroes.Hero;
import homeWork.homeWork1.panels.СardHero;

public class MainHero {
    public static void main(String[] args) {
        Hero hero = new Hero("src/main/image/br.jpg", "Bristleback", "Look who's here, ha ha ha!", "Well, it has begun!", "I like that!");
        СardHero cardHero = new СardHero(hero);
        cardHero.setVisible(true);
    }
}
