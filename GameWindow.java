package ru.geekbreans.lesson7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    private static final int WIN_WIDTH = 507; //имя костант имеюют смысловое заначение
    private static final int WIN_HEIGHT = 555;
    private static final int WIN_POSX = 650;
    private static final int WIN_POSY = 250;

    private Map map; // объявлена вне конструктора чтоб увеличить видимость поля
    private Settings settings;

    GameWindow() { //констуктор класса GameWindow
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // при нажатии на крестик закрытие программы
                                                                 // имеет отношение только к этому окну, всего есть
                                                                 // 3 параметра 0, 1, 2, 3
        setTitle("Tic tac toe game"); // надпись окна
        setLocation(WIN_POSX, WIN_POSY); //место положения окна на рабочем столе
        setSize(WIN_WIDTH, WIN_HEIGHT); // размер окна

        JButton btnStart = new JButton("Start"); // создать кнопу с надписью Старт
        JButton btnExit = new JButton("Exit"); // -//-
        JPanel panelButtons = new JPanel(new GridLayout(1, 2)); // создать новый класс jPanel, панель GridLayout состоящую
                                                                           // из колонок и столбцов
                                                                           // по умолчанию всегда создается компановщик
                                                                           // BorderLayout c 5 отсеками. Север, Юг,
        //                                                                 //Запад, Восток, Центр
        panelButtons.add(btnStart); //добавить на панетль кнопки
        panelButtons.add(btnExit);
        btnExit.addActionListener(new ActionListener() { // добавить слушатель действий
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // в случае нажатия кнопки Exit выйти из приложения
            }
        });
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true); //при нажатии кнопки Start сделать окно видимым
            }
        });
        map = new Map(); // получить новый экземпляр класса Мар
        settings = new Settings(this); // получить новый экземпляр класса Settings
                                                    // и передать ссылку на себя для инкапсуляции

        add(map, BorderLayout.CENTER); // установить класс Мар в центр компановщика BorderLayout
        add(panelButtons, BorderLayout.SOUTH);  // добавить панель с кнопками на юг
        setVisible(true); // включает видимость окна
    }

    void start(int gameMode, int fieldSizeX, int fieldSizeY, int winLength) {
        map.startNewGame(gameMode, fieldSizeX, fieldSizeY, winLength);
    }

}
