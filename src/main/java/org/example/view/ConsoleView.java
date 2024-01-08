package org.example.view;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ConsoleView implements View {

    Scanner scanner;

    public ConsoleView() {
        scanner = new Scanner(System.in);
    }

    public void consoleClear() {
        System.out.print("\033[H\033[J");
    }

    public String showMenu() {
        System.out.println("Меню розыгрыша игрушек:\n" + //
                "1. Добавить игрушку в розыгрыш\n" + //
                "2. Вывести все добавленные игрушки\n" + //
                "3. Выбрать призовую игрушку из коробки\n" + //
                "4. Вывести список призовых игрушек\n" + //
                "5. Выдать призовую игрушку из очереди\n" + //
                "0. Выход из программы\n" + //
                "\n" + //
                "Ваш выбор:");
        return scanner.nextLine();

    }

    public void userWaiting() {
        System.out.println("Нажмите Enter, чтобы продолжить");
        scanner.nextLine();
    }

    public void showSuccessAddinMess() {
        System.out.println("игрушка добавлена успешно!");

    }

    public void showAddinToPrizeBoxMess() {
        System.out.println("Игрушка добавлена в очередь на выдачу.");
    }

    public void showPrizeToyMess() {
        System.out.println("Выдается игрушка:");
    }

    public void showSuccessDrawingMess() {
        System.out.println("Розыгрыш проведен! Выпала следующая игрушка:");

    }
    public void showEmptyBoxMess() {
        System.out.println("Коробка пуста!");
    }

    public void showEmptyQueueMess() {
        System.out.println("Очередь на выдачу пуста!");
    }

    public void showGoobyeMess() {
        System.out.println("Программа завершила работу. До свидания!");
    }

    public void showUnknownCommMess() {
        System.out.println("Такого пункта меню нет");
    }

    public int getId() {
        System.out.println("Введите ID игрушки, которую надо изменить: ");
        try {
            int toyId = Integer.parseInt(scanner.nextLine());
            System.out.println("Успех: id принят!");
            return toyId;
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введите число");
        }
        return -1;
    }

    @Override
    public String getToyName() {
        System.out.print("Имя игрушки: ");
        String toyName = scanner.nextLine();
        try {
            byte[] bytes;
            bytes = toyName.getBytes(StandardCharsets.ISO_8859_1);
            return new String(bytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int getToyProbability() {
        int probability = -1;
        while (probability > 100 || probability < 0) {
            System.out.print("Вес игрушки от 0 до 100: ");
            if (!scanner.hasNextLine()) {
                System.out.println("Ошибка: поток ввода закрыт");
                return -1;
            }
            try {
                probability = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите число от 0 до 100");
            }
        }
        return probability;
    }

    @Override
    public void display(String data) {
        System.out.println(data);

    }
}