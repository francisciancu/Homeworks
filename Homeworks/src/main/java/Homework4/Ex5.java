package Homework4;

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enster a number:");
        int number = scanner.nextInt();
        for (int i = 1; i<=10;i++){
            System.out.println(number + " * " + i + " = " + number*i);
        }
    }
}
