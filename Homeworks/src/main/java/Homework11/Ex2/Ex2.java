package Homework11.Ex2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Ex2 {
    final static String[] textArray = {"Alba", "Iasi", "Bacau", "Constanta"};
    final static Integer[] intArray = {100, 500, 300, 400, 200};
    final static Character[] charArray = {'a', 'b', 'd', 'c'};

    public static <T> void order(T...values) {
        Arrays.sort(values);
        System.out.println(Arrays.toString(values));

    }
    public static void main(String[] args) {
        order(textArray);
        order(intArray);
        order(charArray);
    }
}
