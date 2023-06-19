package Homework9;

public class Monkey extends Primate implements BasicNeeds {
    public Monkey() {
        System.out.println("Primate dataType instance of Monkey:");
        System.out.println("----------------------------------------------------------------------");
        walk();
        run();
        System.out.println(eat());
        sleep();
        speak("monkey");
    }

    @Override
    public String eat() {
        return "Mostly herbivore";
    }

    @Override
    public void sleep() {
        System.out.println("I need to sleep");
    }

    @Override
    public void drink() {
    }
}
