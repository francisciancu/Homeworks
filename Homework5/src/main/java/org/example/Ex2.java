package org.example;

public class Ex2 {
    public static void main(String[] args) {
        int howMany = 9;
        int number0 = 0;
        int number1 = 1;
        System.out.println(" For : ");
        for ( int i = 0 ; i < howMany ; i++ ){
            System.out.print(number0 + " ");
            int number2 = number0 + number1;
            number0 = number1;
            number1 = number2;
        }
        System.out.println("\n While : ");
        number0 = 0;
        number1 = 1;
        while ( howMany > 0 ) {
            System.out.print(number0 + " ");
            int number2 = number0 + number1;
            number0 = number1;
            number1 = number2;
            howMany--;
        }
    }

}
