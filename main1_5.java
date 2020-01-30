package ru.geekbreans.lesson5;

public class main1_5 {
    public static void main(String [] args){
        Bird b = new Bird(5,0,0.2f,11, 20);
        Cat c = new Cat(200, 0,2, 2, 17);
        Dog d = new Dog(500,10, 0.5f,8, 15);
        Horse h = new Horse(1500, 100,3,4, 30);


        System.out.println("Птица пробегает: " + b.getRun(b.getAge()) + " m.\n" +
                           "Кошка прыгает: " + c.getJump(c.getAge()) + " m.\n" +
                           "Собака проплывает: " + d.getSail(d.getAge()) + " m.\n" +
                           "Собака прыгает: " + d.getJump(d.getAge()) + " m.\n"
        );
    }
}
