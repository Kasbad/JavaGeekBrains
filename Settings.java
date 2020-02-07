package ru.geekbreans.lesson7;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JFrame {
    private static final int WINDOW_WIDTH = 350;//размеры окна
    private static final int WINDOW_HEIGHT = 270;
    private GameWindow gameWindow; // показать какое окно создало окно Settings

    private JRadioButton jrbHumVsAi; //создать радиокнопки
    private JRadioButton jrbHumVsHum;
    private JSlider jsFieldSize; // создать слайдеры
    private JSlider jsWinLength;
    private static final String FIELD_SIZE_PREFIX = "Field size is: "; // просто строки с текстом
    private static final String WIN_LENGTH_PREFIX = "Winning length is: ";
    private static final int MIN_FIELD_SIZE = 3; //минимальный размер поля
    private static final int MAX_FIELD_SIZE = 10;//максимальный размер поля
    private static final int MIN_WIN_LENGTH = 3;//условия победы х элементов в ряд

    Settings(GameWindow gameWindow) { // передать в конструктор прараметры окна gameWindow
        this.gameWindow = gameWindow;
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT); // здесь не понял что за функция
        Rectangle gameWindowBounds = gameWindow.getBounds(); //получить какой то квадрат
        int posX = (int) gameWindowBounds.getCenterX() - WINDOW_WIDTH / 2; // взять центр родительского окна по х и по y
        int posY = (int) gameWindowBounds.getCenterY() - WINDOW_HEIGHT / 2;// и поделить на 2
        setLocation(posX, posY); // установить окно в полученные коодинаты
        setResizable(false); // запретить изменять размер окна
        setTitle("Creating a new game"); //название окна
        setLayout(new GridLayout(10, 1)); // разлиновать окно компановщиком
        addGameModeControls(); // вызвать метод для похудения
        addFieldControls();
        JButton btnStart = new JButton("Start a game"); // создать кнопку стар игры
        btnStart.addActionListener(new ActionListener() { // слушатель кнопки
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame(); // запустить игру
            }
        });
        add(btnStart); // добавить кнопку стар игры
    }

    private void addGameModeControls() {
        add(new JLabel("Choose game mode")); // добавить написть на окно
        jrbHumVsAi = new JRadioButton("Human vs. AI", true); // добавить радио кнопку и поставить на нее фокус
        jrbHumVsHum = new JRadioButton("Human vs Human");
        ButtonGroup mode = new ButtonGroup();// зоздать группу для радиокнопок
        mode.add(jrbHumVsAi); //добавить их групп
        mode.add(jrbHumVsHum);
        add(jrbHumVsAi); // добавить радио кнопки на окно
        add(jrbHumVsHum);
    }

    private void addFieldControls() {
        JLabel jlFieldSize = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE); //просто строковые константы
        JLabel jlWinLength = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_LENGTH); // окта GameWindows
        jsFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);// минимальный размер поля,максимальный и куда поставить ползунок
        jsWinLength = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MIN_WIN_LENGTH);// тоже самое что и сверху но для условия победы
        jsFieldSize.addChangeListener(new ChangeListener() { // слушатель текушего значения слайдера
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = jsFieldSize.getValue(); // получить текущее зачение
                jlFieldSize.setText(FIELD_SIZE_PREFIX + currentValue);// установить текст строка + текущее значение
                jsWinLength.setMaximum(currentValue); // установить максимальную длину выгрышной линии
                                                      // в зависимости от размера поля
            }
        });
        jsWinLength.addChangeListener(new ChangeListener() { // слушатель выйгрышной длины
            @Override
            public void stateChanged(ChangeEvent e) {
                jlWinLength.setText(WIN_LENGTH_PREFIX + jsWinLength.getValue());
            }
        });
        add(new JLabel("Choose field size"));
        add(jlFieldSize);
        add(jsFieldSize);
        add(new JLabel("Choose winning length"));
        add(jlWinLength);
        add(jsWinLength);
    }

    private void startGame() {
        int gameMode;
        if (jrbHumVsAi.isSelected()) { //выбор режима игры
            gameMode = Map.GAME_MODE_HVA; // человек с компьютером
        } else if (jrbHumVsHum.isSelected()) {
            gameMode = Map.GAME_MODE_HVH; // компьютер с комютером
        } else {
            throw new RuntimeException("Unexpected game mode"); // возможность расширения на будущие, напоминалка для
                                                                // себя если добавить еще одну радио кнопку режима игры
        }

        int fieldSize = jsFieldSize.getValue(); // получить значение поля
        int winLength = jsWinLength.getValue(); // получить значение выйгрышной длины

        gameWindow.start(gameMode, fieldSize, fieldSize, winLength);
        setVisible(false); // окно Settings невидимым
    }
}

