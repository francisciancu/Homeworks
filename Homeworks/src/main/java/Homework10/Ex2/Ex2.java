package Homework10.Ex2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex2 {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("Product1", "Product2", "Product3", "Product4", "Product5");
        List<String> list2 = Arrays.asList("Product1", "Product2", "Product6", "Product4", "Product8");
        List<String> raspunsuri = new ArrayList<>();
        boolean condition = false;
        for (String elementList1 : list1) {
            for (String elementList2 : list2) {
                if (elementList1.equals(elementList2)) {
                    condition = true;
                    break;
                }
            }
            if (condition) {
                raspunsuri.add("YES");
            } else {
                raspunsuri.add("NO");
            }
            condition = false;
        }
        for (String answer : raspunsuri) {
            System.out.print(answer + " ");
        }


    }
}
