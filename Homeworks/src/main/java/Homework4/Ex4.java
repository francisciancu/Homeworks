package Homework4;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        for (int i = 1;i<=10;i++){
            System.out.println("Please enter number " + i);
            int number = scanner.nextInt();
            sum += number;
        }
        System.out.println("The sum of the numbers is : " + sum);
    }
}
