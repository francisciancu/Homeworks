package Homework3;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your age?");
        int age = scanner.nextInt();

        if (age<18){
            System.out.println("Esti minor");

        } else if (age<=65){
            System.out.println("Esti adult");

        } else {
            System.out.println("Esti batran");

        }
    }
}
