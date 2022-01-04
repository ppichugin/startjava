package com.startjava.lesson_2_3_4.game;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    private int secretNumber;
    private final Player playerOne;
    private final Player playerTwo;

    public GuessNumber(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void start() {
        generateSecretNumber();
        System.out.println("Компьютер загадал число. Начинаем игру !");
        System.out.println("У каждого игрока по 10 попыток.");
        for (int i = 0; i < 10; i++) {
            System.out.println("----- Попытка № " + (i + 1));
            inputNumber(playerOne);
            if (checkNumber(playerOne)) break;
            inputNumber(playerTwo);
            if (checkNumber(playerTwo)) break;
        }
        setUp(playerOne);
        setUp(playerTwo);
    }

    private void generateSecretNumber() {
        Random r = new Random();
        secretNumber = r.nextInt(100) + 1;
    }

    private void inputNumber(Player player) {
        Scanner sc = new Scanner(System.in);
        boolean isInputNumberCorrect;
        do {
            System.out.print(player.getName() + ", введите число [1, 100]: ");
            isInputNumberCorrect = player.setNumber(sc.nextInt());
        } while (!isInputNumberCorrect);
        player.setAttempt(player.getAttempt() + 1);
    }

    private boolean checkNumber(Player player) {
        if (player.getNumber() < secretNumber) {
            System.out.println(player.getName() + ", введенное число '" + player.getNumber() + "' меньше загаданного.");
        } else if (player.getNumber() > secretNumber) {
            System.out.println(player.getName() + ", введенное число '" + player.getNumber() + "' больше загаданного.");
        }
        if (player.getAttempt() == 10) {
            System.out.println("У " + player.getName() + " закончились попытки");
        }
        if (player.getNumber() == secretNumber) {
            System.out.printf("%S%s%d%n\n", player.getName(), ", Вы угадали число!!! Это: ", player.getNumber());
            System.out.println("Игрок " + player.getName() + " угадал число " + player.getNumber() + " с " + player.getAttempt() + " попытки");
            return true;
        }
        return false;
    }

    public void setUp(Player player) {
        System.out.println("Числа игрока " + player.getName() + ": " + Arrays.toString(player.getGuessedNumbers()).replaceAll("\\D+", " "));
        player.resetAllNumbers();
        player.setAttempt(0);
    }
}