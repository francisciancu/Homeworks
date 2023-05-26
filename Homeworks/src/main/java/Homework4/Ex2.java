package Homework4;

public class Ex2 {
    public static void main(String[] args) {
        int comision;
        int vanzari = 3500;
        if (vanzari>2500){
            comision = vanzari*5/100;
        }else {
            comision = 0;
        }
        System.out.println("Comisionul tau este:" + comision);
    }
}
