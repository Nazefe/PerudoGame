package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Registration {
    private static final String[] NAME1_PARTS = {"Crazy", "Elder", "Strong", "Smaller", "Lucky"};
    private static final String[] NAME2_PARTS = {"Monkey", "Bread", "Billi", "GrandFather", "Plum"};

    public String registerPlayer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите способ регистрации:");
        System.out.println("1. Ввести имя игрока");
        System.out.println("2. Сгенерировать имя автоматически");

        while (true) {
            if (sc.hasNextInt()) {
                int choice = sc.nextInt();
                sc.nextLine();
                if (choice == 1) {
                    System.out.print("Введите имя игрока: ");
                    String playerName = sc.nextLine();
                    System.out.println("Ваше имя: " + playerName);
                    return playerName;
                } else if (choice == 2) {
                    String playerName = generateRandomName();
                    System.out.println("Сгенерированное имя: " + playerName);
                    return playerName;
                } else {
                    System.out.println("Некорректный ввод. Пожалуйста, попробуйте снова.");
                }
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, введите число.");
                sc.next();
            }
        }
    }

    public List<String> generateComputerPlayers(int count) {
        List<String> computerPlayers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            computerPlayers.add(generateRandomName());
        }
        return computerPlayers;
    }

    private String generateRandomName() {
        Random random = new Random();
        String namePart1 = NAME1_PARTS[random.nextInt(NAME1_PARTS.length)];
        String namePart2 = NAME2_PARTS[random.nextInt(NAME2_PARTS.length)];
        int number = random.nextInt(100001);
        return namePart1 + namePart2 + number;
    }
}

class Game {
    public void Look() {
        Registration registration = new Registration();
        // Регистрация игрока
        String playerName = registration.registerPlayer();

        List<String> computerPlayers = registration.generateComputerPlayers(3);

        // Вывод имен всех участников
        System.out.println("Игра начинается!");
        System.out.println("Игроки:");
        System.out.println("Человек: " + playerName);

        System.out.println("Компьютеры:");
        for (String computerPlayer : computerPlayers) {
            System.out.println(computerPlayer);
        }
    }
}
