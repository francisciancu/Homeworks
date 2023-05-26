package Homework4;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ce punctaj ai primit?");
        int punctaj = scanner.nextInt();

        String calificativ = punctaj>=90?"FB":punctaj>=80?"B":"S";

        System.out.println((calificativ.equals("FB"))?"Ai primit : Foarte Bine":(calificativ.equals("B"))?"Ai primit : Bine":"Ai primit : Suficient");

    }
}
