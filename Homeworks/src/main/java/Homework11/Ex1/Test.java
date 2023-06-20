package Homework11.Ex1;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        GeneratePropertiesFile obj =  new GeneratePropertiesFile();
        Scanner scanner = new Scanner(System.in);
        obj.writePropertiesFile();
        boolean condition = true;
        while (condition){
            System.out.println("Doresti sa cumperi ceva?");
            System.out.println("1. DA");
            System.out.println("2. NU");
            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.println("Ce doresti sa cumperi?");
                    System.out.println("Variante : portocala, mar, ananas, banana, lamaie.");
                    obj.readPropertiesFile(scanner.next());
                }
                case 2 -> condition = false;
            }
        }
    }
}
