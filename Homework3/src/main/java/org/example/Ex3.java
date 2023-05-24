package org.example;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("What day is today?");

        int day = scanner.nextInt();
        boolean condition = false;
        while (!condition){
            if (day<=0){
                System.out.println("Te rog sa introduci un numar mai mare ca 0");
                day = scanner.nextInt();

            } else if (day>7) {
                System.out.println("Saptamana are doar 7 zile te rog sa introduci un numar valid");
                day = scanner.nextInt();

            } else {
                condition = true;

            }

        }
        if (day==1){
            System.out.println("Astazi este luni");

        } else if (day==2) {
            System.out.println("Astazi este marti");

        } else if (day==3) {
            System.out.println("Astazi este miercuri");

        } else if (day==4) {
            System.out.println("Astazi este joi");

        } else if (day==5) {
            System.out.println("Astazi este vineri");

        } else if (day==6) {
            System.out.println("Astazi este sambata");

        } else {
            System.out.println("Astazi este duminica");

        }

    }
}
