package org.example;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean condition;
        int attempts = 0;
        do {
            System.out.println("User:");
            String user = scanner.next();
            System.out.println("Password:");
            int password = scanner.nextInt();
            attempts+=1;
            condition = user.equals("TestUser") && password == 1234 || ( attempts > 2 );
            System.out.println(( user.equals( "TestUser" ) && password == 1234 ) ? "Login Successful":( attempts < 3 )?"Login Error":"Maximum attempts reached. User Blocked");
        }while (!condition);




    }
}
