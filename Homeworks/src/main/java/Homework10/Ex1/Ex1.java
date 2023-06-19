package Homework10.Ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Ex1Elev> catalog = new ArrayList<>();
        boolean condition = true;
        while (condition) {
            System.out.println("Ce doresti sa faci?");
            System.out.println("1. Verifica elev");
            System.out.println("2. Nu mai verifica elevi");
            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.println("Nume elev:");
                    String nume = scanner.next();
                    System.out.println("Nota elev:");
                    double nota = scanner.nextDouble();
                    if (catalog.size() == 0) {
                        catalog.add(new Ex1Elev(nume, nota));
                    }
                    boolean elevGasit = false;
                    for (Ex1Elev elev : catalog) {
                        if (elev.getNume().equals(nume)) {
                            if (elev.getNota() >= nota) {
                                System.out.println("Nu ai nevoie de alta nota");
                            } else {
                                elev.setNota(nota);
                            }
                            elevGasit = true;
                            break;
                        }
                    }
                    if (!elevGasit) {
                        catalog.add(new Ex1Elev(nume, nota));
                    }
                }
                case 2 -> {
                    condition = false;
                }
            }
        }
        if (catalog.size() == 0) {
            System.out.println("Nu sunt elevi in catalog");
        } else {
            System.out.println("Catalog:");
            for (Ex1Elev elev : catalog) {
                System.out.println("Nume: " + elev.getNume() + "   Nota: " + elev.getNota());
            }
        }

    }
}
