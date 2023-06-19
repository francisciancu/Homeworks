package Homework8;

public class InsufficientFundsException extends Exception {
    public InsufficientFundsException() {
        super("Insuficient funds for transaction");
    }
}
