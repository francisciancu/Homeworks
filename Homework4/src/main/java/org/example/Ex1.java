package org.example;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Care este valoarea facturii?");
        double valoareFactura = scanner.nextDouble();

        double valoareDiscount = valoareFactura>=100 ? valoareFactura/10 : valoareFactura/20;

        System.out.println("Pret nou " + (valoareFactura-valoareDiscount));
    }
}
