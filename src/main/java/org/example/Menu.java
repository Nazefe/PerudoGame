package org.example;

import java.util.Scanner;
import java.io.*;

public class Menu {
    public void start() {
        Scanner sc = new Scanner(System.in);
        boolean exit = false; // Флаг для выхода из программы while (!exit) {
        System.out.println("Добро пожаловать в меню!");
        System.out.println("1. Начать игру");
        System.out.println("2. Правила игры");
        System.out.println("3. Выйти");

        if (sc.hasNextInt()) {
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    startGame(sc);
                    break;
                case 2:
                    showRules(sc);
                    Menu2(sc);
                    break;
                case 3:
                    System.out.println("Выход из программы.");
                    exit = true;
                    break;
                default:
                    System.out.println("Некорректный ввод. Пожалуйста, попробуйте снова.");
                    break;
            }
        } else {
            System.out.println("Некорректный ввод. Пожалуйста, введите число.");
            sc.next(); // Очистка некорректного ввода }
        }
    }

    private void startGame(Scanner sc) {
        System.out.println("Игра началась!");
        Game game = new Game();
        game.Look();
    }

    private void showRules(Scanner sc) {
        try (FileReader reader = new FileReader("rules.txt")) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
            System.out.println(); // Переход на новую строку после вывода правил
        } catch (IOException ex) {
            System.out.println("Ошибка при чтении файла: " + ex.getMessage());
        }
    }
    private void Menu2(Scanner sc) {
        System.out.println("Выберите действие:");
        System.out.println("1. Вернуться в меню");
        System.out.println("2. Завершить работу");

        while (true) {
            if (sc.hasNextInt()) {
                int choice = sc.nextInt();
                sc.nextLine(); // Очистка новой строки после ввода числа
                if (choice == 1) {
                    Menu menu = new Menu();
                    menu.start();
                    break; // Возвращаемся в главное меню
                } else if (choice == 2) {
                    System.exit(0); // Завершаем программу
                } else {
                    System.out.println("Некорректный ввод. Пожалуйста, попробуйте снова.");
                }
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, введите число.");
                sc.next(); // Очистка некорректного ввода }
            }
        }
    }
}
