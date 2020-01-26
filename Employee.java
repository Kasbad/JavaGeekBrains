package ru.geekbreans.lesson4;

public class Employee {

    String FIO;
    String position;
    String phone;
    int salary;
    int age;
    //задание2 Конструктор класса должен заполнять эти поля при создании объекта;
    Employee(String pFIO, String pPosition, String pPhone, int pSalary, int pAge){
        FIO = pFIO;
        position = pPosition;
        phone = pPhone;
        salary = pSalary;
        age = pAge;
    }

    // Задание3: Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля;
    String reField(){
        return "ФИО: " + FIO + ", Професия:" +  position + ", Номер телефона: " + phone + ", Зарплата: " + salary + ", Возраст: " + age;

    }

    //задание4: Вывести при помощи методов из пункта 3 ФИО и должность
    String reField(String FIO, String position){
        return FIO + ", " + position +".";
    }

    //задание5 Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
    Employee(String arrPers[][]){
        for(int i=0;i<arrPers.length;i++){
            if(Integer.parseInt(arrPers[i][4]) > 40){
                System.out.println("_________");
                for(int j=0;j<arrPers.length;j++){
                    System.out.println(arrPers[i][j]);
                }
            }

            //задание6 * Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000.
            if(Integer.parseInt(arrPers[i][4]) > 45){
                arrPers[i][3] = Prize(Integer.parseInt(arrPers[i][3]));
                System.out.print("Начисление премии\n_________________\n" );
                for(int j=0;j<arrPers.length;j++){
                    System.out.println(arrPers[i][j]);
                }
            }
        }

    }

    //задание6 * Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000.
    private String Prize(int add){
       int addPriz = 5000;
        return add+addPriz+"";
    }

    //задание7  Средние арифметические возраста и зарплаты
     String average(int aveAge, int aveSalary, String arrPers[][]){
        int aA = aveAge;
        int  aS = aveSalary;
         for(int i=0;i<arrPers.length;i++){
             aveAge += Integer.parseInt(arrPers[i][aA]);
             aveSalary += Integer.parseInt(arrPers[i][aS]);
         }
        return "Средний возрост: " + aveAge/arrPers.length + ", " + "Средняя зарплата: " + aveSalary/arrPers.length;
    }

}
