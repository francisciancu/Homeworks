package Homework7;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        System.out.println("Cate elemente trebuie sa aiba array-ul:");
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            System.out.print("Introdu elementrul " + (i + 1) + " : ");
            array[i] = scanner.nextInt();
        }
        System.out.println("Ordinea originala : ");
        for (int i = 0; i < arrayLength; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("\nOrdinea inversa cu for : ");
        for (int i = arrayLength-1; i >=0; i--) {
            System.out.print(array[i] + " ");
        }

        System.out.println("\nOrdinea inversa cu while : ");
        while (arrayLength-1>=0){
            System.out.print(array[arrayLength-1] + " ");
            arrayLength--;
        }
    }
}
