package ru.geekbreans.lesson7;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {
    public static final int GAME_MODE_HVH = 0; //выбор режима игры
    public static final int GAME_MODE_HVA = 1;


    Map() { //создоть конструкор Мар, метода Мар
        setBackground(Color.GRAY); // покрасить поле в серый цвет


    }

    void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int winLength) { // заглунка для проверки как
                                                                                    // отрабатывают медоды
        System.out.printf("game mode: %d\nfieldSize: %d\nwinLength: %d",           //  получает игровые параметры из класса Settings
                gameMode, fieldSizeX, winLength);

        JPanel panelFields = new JPanel(new GridLayout(fieldSizeX, fieldSizeY));
        JTextField bigField1 = new JTextField("Текст поля", 25);
        JTextField bigField2 = new JTextField("Текст поля", 25);
        JTextField bigField3 = new JTextField("Текст поля", 25);
        JTextField bigField4 = new JTextField("Текст поля", 25);
        JTextField bigField5 = new JTextField("Текст поля", 25);
        JTextField bigField6 = new JTextField("Текст поля", 25);
        JTextField bigField7 = new JTextField("Текст поля", 25);

        //JPanel panelFilds = new JPanel(new GridLayout(3, 3));
        //for(int i = 0;i<=3*3;i++){
        panelFields.add(bigField1);
        panelFields.add(bigField2);
        panelFields.add(bigField3);
        panelFields.add(bigField4);
        panelFields.add(bigField5);
        panelFields.add(bigField6);
        panelFields.add(bigField7);
    }
}

