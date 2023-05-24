package org.example;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your score?");
        int score = scanner.nextInt();

        if (score>=0 && score<=65){
            System.out.println("Ai picat. Mai incearca");

        } else if (score>=66){
            System.out.println("Felicitari, Ai trecut");

        }
    }
}
