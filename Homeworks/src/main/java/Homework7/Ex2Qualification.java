package Homework7;

public class Ex2Qualification extends Ex2Teacher {
//    Nu prea am inteles din cerinta ce exact se cere
//     -> " In cadrul acestei clase avem un constuctor care seteaza caracteristicle din Teacher "
    public Ex2Qualification(Ex2Teacher teacher) {
        super(teacher.course, teacher.experienceYears, teacher.schedule);
    }

    public void verify(Ex2Teacher teacher){
        if(teacher.experienceYears >3 && teacher.course.equals("Java") && teacher.schedule.equals("Afternoon")){
            System.out.println("You qualify to teach at this school!");
        }else {
            System.out.println("You do not qualify!");
        }
    }
}
