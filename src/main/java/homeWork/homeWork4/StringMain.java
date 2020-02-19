package homeWork.homeWork4;

import java.util.ArrayList;
import java.util.List;

public class StringMain {
    public static void main(String[] args) {
        List<String> wordList = new ArrayList<String>();
        wordList.add("A");
        wordList.add("B");
        wordList.add("C");
        wordList.add("D");
        wordList.add("G");
        wordList.parallelStream().map(w -> w.concat("A")).forEach(w -> System.out.println(w));
    }
}
