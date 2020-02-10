package ru.geekbreans.lesson6;

import java.io.*;
import java.util.Scanner;

public class Main1_6 {
    public static void main(String[] args) {
        String str = "Строковая переменная";
        try{
            //задание1 Создать 2 текстовых файла, примерно по 50-100 символов в каждом(особого значения не имеет);
            PrintStream ps1 = new PrintStream("D://test1.txt");
            ps1.println("Первый файл с текстом. \nДобавлен перенос строки в первый файл\nString for third task");
            ps1.close();
            PrintStream ps2 = new PrintStream("D://test2.txt");
            ps2.println("Второй файл с текстом \nДобавлена строковая переменная str:\n" + str + "\nВо втором файле");
            ps2.close();

            //задание2 Написать программу, «склеивающую» эти файлы,
            // то есть вначале идет текст из первого файла, потом текст из второго.
            FileWriter writer = new FileWriter("D://test1.txt", true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            FileReader fr = new FileReader( "D://test2.txt" );
            Scanner scan = new Scanner(fr);

            while (scan.hasNextLine()) {
                bufferWriter.write(String.valueOf(scan.nextLine() + "\n"));
            }
            bufferWriter.close();
            fr.close();
        } catch (IOException e){
            throw new RuntimeException(e);
        }

        // задание3 *Написать программу, которая проверяет присутствует ли
        // указанное пользователем слово в файле (работаем только с латиницей).
        try(FileInputStream fin=new FileInputStream("D://test1.txt")){
            StringBuffer strRead = new StringBuffer();
            FileReader fr = new FileReader( "D://test1.txt" );
            Scanner scan = new Scanner(fr);

            while(scan.hasNextLine()) {
                strRead.append(String.valueOf(scan.nextLine()));
            }
            if (strRead.indexOf("for") > 0) System.out.print("Слово for найдено в строке \n");

        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        //задание4
        //** Написать метод, проверяющий, есть ли указанное слово в папке (Почитайте реализацию класса File)
        try{
            File f = new File("D://");
            String[] list = f.list();
            for (String file : list) {
                if ("test1.txt".equals(file)) {
                    System.out.println("В папке " + f + " найден файл с наззванием test1.txt");  //если найден, то выход
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
