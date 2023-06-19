package Homework9;

public class Human extends Primate implements BasicNeeds {
    public Human() {
        System.out.println("Primate dataType instance of Human:");
        System.out.println("----------------------------------------------------------------------");
        walk();
        run();
        System.out.println(eat());
        sleep();
        speak("human");
    }

    @Override
    public String eat() {
        return "Omnivore";
    }

    @Override
    public void sleep() {
        System.out.println("I need to sleep");
    }

    @Override
    public void drink() {
    }
}
