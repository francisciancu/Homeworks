package Homework7;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        int[] array = new int[10];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            System.out.print("Introdu numarul " + (i + 1) + " : ");
            array[i] = scanner.nextInt();
        }
        System.out.println("\nAfisare numere pare cu FOR : ");
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println("\nAfisare numere pare cu WHILE : ");
        int arrayLength = array.length;
        while ((array.length - arrayLength) < 10) {
            if (array[array.length - arrayLength] % 2 == 0) {
                System.out.print(array[array.length - arrayLength] + " ");
            }
            arrayLength--;
        }
    }
}
