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
    }
}

