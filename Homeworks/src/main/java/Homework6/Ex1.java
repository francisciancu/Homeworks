package Homework6;

import java.util.Scanner;
//e extrem de fortat sa mearga cu switch pe cat posibil am putut

public class Ex1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introdu anul de vechime:");
        int anVechime = scanner.nextInt();
        int bonus = 0;

        switch (anVechime) {

            case 1:
                bonus = 100;
                break;

            case 2:
                bonus = 200;
                break;

            case 3: {

                System.out.println("Introdu valoarea vanzarilor efectuate:");
                int valoareVanzari = scanner.nextInt();

                int condition1 = valoareVanzari <= 5000 ? 0 : valoareVanzari <= 10000 ? 1 : 2;

                switch (condition1) {

                    case 0: {
                        bonus = 600;
                        break;
                    }

                    case 1: {
                        System.out.println("Introdu luna in care ai efectuat vanzarile: ( 1 - 12)");
                        int lunaVanzari = scanner.nextInt();
                        // aici mergea facut si cu switch(lunaVanzari){
                        // case 1: <- fara break; la astea pentru ca daca una o gaseste adevarata ruleaza pana cand da de break adica la case 6 si oricum coicide ce trebuie sa faca
                        // case 2:
                        // .
                        // case 6: bonus = 800; break;
                        // case 7: <- fara break; la astea pentru ca daca una o gaseste adevarata ruleaza pana cand da de break adica la case 11 si oricum coicide ce trebuie sa faca
                        // case 8:
                        // .
                        // case 11: bonus = 1000: break;
                        // case 12: bonus = 900 System.out.println("In decembrie se vand singure!"); break;
                        //}
                        int condition2 = (lunaVanzari >= 1 && lunaVanzari <= 6) ? 0 : (lunaVanzari > 6 && lunaVanzari <= 11) ? 1 : (lunaVanzari == 12) ? 2 : 3;
                        switch (condition2) {

                            case 0:
                                bonus = 800;
                                break;

                            case 1:
                                bonus = 1000;
                                break;

                            case 2:
                                bonus = 900;
                                System.out.println("In decembrie se vand singure!");
                                break;

                            default:
                                System.out.println("Ai introdus o luna gresita");

                        }
                        break;

                    }

                    case 2: {
                        bonus = 1200;
                        break;

                    }

                }
                break;

            }
            default:
                System.out.println("Anul trebuie sa fie 1-3");

        }

        if (bonus != 0) {
            System.out.println("Ai primit bonus de " + bonus);

        }

    }

}