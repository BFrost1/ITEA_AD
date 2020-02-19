package homeWork.homeWork4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IntegerMain {
    public static void main(String[] args) {
        List <Integer> numList = new ArrayList<Integer>();
        numList.add(5);
        numList.add(4);
        numList.add(3);
        numList.add(2);
        numList.add(1);
        numList.add(6);
        numList.add(7);
        numList.add(8);
        numList.add(9);
        numList.add(10);

        List<Integer> resultList = numList.stream().filter(e -> e % 2 ==0).sorted().collect(Collectors.toList());

        for (Integer integer : resultList) {
            System.out.println(integer);
        }
    }
 }
