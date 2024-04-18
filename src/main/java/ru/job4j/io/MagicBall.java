package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Я великий Java оракл. Что ты хочешь узнать?");
            String question = scanner.nextLine();
            int random = new Random().nextInt(3);
            String answer = switch (random) {
                case 0 -> "Да";
                case 1 -> "Нет";
                default -> "Может быть";
            };
            System.out.println(random);
            System.out.format("Ответ на вопрос \"%s\" следующий: %s", question, answer);
    }
}
