package Homework8;

public class SavingsAccount extends Account {
    public SavingsAccount(int accountNumber, double balance, Customer accountOwner) {
        super(accountNumber, balance, accountOwner);
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            System.out.println("The amount you entered is greater than the available " + balance);
            System.out.println("Thank you for using out ATM!");
            throw new InsufficientFundsException();
        } else {
            balance -= amount;
            System.out.println("Please pick your money.");
            System.out.println("Your new balance is " + balance);
            System.out.println("Thank you for using out ATM!");
        }
    }
}
