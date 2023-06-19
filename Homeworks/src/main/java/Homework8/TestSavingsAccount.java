package Homework8;

import java.util.Scanner;

public class TestSavingsAccount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer("Mihai", "Acasa1", "email@email.com");
        SavingsAccount savingsAccount = new SavingsAccount(1234567, 1000, customer);
        System.out.println("Salut " + customer.getName());
        System.out.println("Please enter  the amount  to withdraw:");
        try {
            savingsAccount.withdraw(scanner.nextInt());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
