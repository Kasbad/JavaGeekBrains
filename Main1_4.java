package ru.geekbreans.lesson4;

public class Main1_4 {
    public static void main(String[] args){

        String FIO = "Цуканов И.Н.";
        String position = "Программист Java  основной отлел";
        String phone = "+7 123 456 78 90";
        int salary = 250000; //целочисленные сделал чтоб было интересней
        int age = 41;
        //задание2:  Конструктор класса должен заполнять эти поля при создании объекта;
        Employee pers = new Employee(FIO, position, phone, salary, age);

        //задание3: Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля;
        System.out.println(pers.reField());

        //задание4: Вывести при помощи методов из пункта 3 ФИО и должность
        System.out.println(pers.reField(FIO, position));

        //задание5 Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
        String [] [] EmployeeArr = new String [5] [5];
        EmployeeArr [0][0] = FIO;
        EmployeeArr [0][1] = position;
        EmployeeArr [0][2] = phone;
        EmployeeArr [0][3] = salary+"";
        EmployeeArr [0][4] = age+"";
        EmployeeArr [1][0] = "Пупкин В.В.";
        EmployeeArr [1][1] = "Программист Java отлел 1";
        EmployeeArr [1][2] = "+7 123 456 78 91";
        EmployeeArr [1][3] = "250001";
        EmployeeArr [1][4] = "67";
        EmployeeArr [2][0] = "Иванов Т.С.";
        EmployeeArr [2][1] = "Программист Java отлел 2";
        EmployeeArr [2][2] = "+7 123 456 78 92";
        EmployeeArr [2][3] = "250002";
        EmployeeArr [2][4] = "25";
        EmployeeArr [3][0] = "Степанов В.М.";
        EmployeeArr [3][1] = "Программист Java отлел 3";
        EmployeeArr [3][2] = "+7 123 456 78 93";
        EmployeeArr [3][3] = "250004";
        EmployeeArr [3][4] = "32";
        EmployeeArr [4][0] = "Смирнов Ф.Е.";
        EmployeeArr [4][1] = "Программист Java отлел 4";
        EmployeeArr [4][2] = "+7 123 456 78 94";
        EmployeeArr [4][3] = "250005";
        EmployeeArr [4][4] = "40";

        //задание8 *** Продумать конструктор таким образом,
        // чтобы при создании каждому сотруднику
        // присваивался личный уникальный идентификационный порядковый номер
        for(int i=0;i<EmployeeArr.length;i++){
            EmployeeArr[i][0] = i+1+". " + EmployeeArr[i][0];//на больше не хватило фантазии.
        }
        Employee persArr = new Employee(EmployeeArr);


        //задание7  Средние арифметические возраста и зарплаты
        int aveAge = 4;
        int aveSalary = 3;
        System.out.println(persArr.average(aveAge, aveSalary, EmployeeArr));

    }

}
