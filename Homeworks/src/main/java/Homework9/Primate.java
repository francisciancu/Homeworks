package Homework9;

public class Primate {
    void walk() {
        System.out.println("can walk");
    }

    void run() {
        System.out.println("can run");
    }

    void speak(String dataType) {
        if (dataType.equals("human")){
            System.out.println("I can speak");
        } else if (dataType.equals("monkey")) {
            System.out.println("I cannot speak");
        }
    }
}
