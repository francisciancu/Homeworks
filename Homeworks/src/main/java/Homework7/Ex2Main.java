package Homework7;

public class Ex2Main {
    public static void main(String[] args) {
        Ex2Teacher teacher = new Ex2Teacher("Java",4,"Afternoon");
        Ex2Teacher teacher1 = new Ex2Teacher("NuJava",4,"Afternoon");
        Ex2Teacher teacher2 = new Ex2Teacher("Java",3,"Afternoon");
        Ex2Teacher teacher3 = new Ex2Teacher("Java",4,"NuAfternoon");
        Ex2Teacher teacher4 = new Ex2Teacher("NuJava",3,"NuAfternoon");

        Ex2Qualification qualification = new Ex2Qualification(teacher);
        qualification.verify(teacher);
        qualification.verify(teacher1);
        qualification.verify(teacher2);
        qualification.verify(teacher3);
        qualification.verify(teacher4);

    }
}
