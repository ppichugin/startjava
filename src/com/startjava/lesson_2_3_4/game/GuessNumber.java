package com.startjava.lesson_2_3_4.game;

import java.util.*;

public class GuessNumber {

    private int secretNumber;
    private final Player[] players = new Player[3];
    private final String[] winners = new String[3];
    private int[] orderOfPriority = new int[3];

    public GuessNumber(Player player1, Player player2, Player player3) {
        players[0] = player1;
        players[1] = player2;
        players[2] = player3;
    }

    public void start() {
        System.out.println("У каждого игрока по 10 попыток.");
        System.out.println("Победитель будет определен по результатам трех раундов! Начинаем!");

        for (int round = 0; round < 3; round++) {       // раунды
            generateSecretNumber();
            System.out.println("\nКомпьютер загадал число.");
            System.out.println("=== РАУНД: " + (round + 1));
            // игроки бросают жребий
            lot();
            // начало игры
            for (int i = 0; i < 10; i++) { // попытки
                System.out.println("---- Попытка № " + (i + 1));
                for (int j = 0; j < players.length; j++) { // ходы участников
                    Player player = players[orderOfPriority[j]];
                    inputNumber(player);
                    if (checkNumber(player)) {
                        winners[round] = player.getName();
                        i = 10;
                        break;
                    }
                }
            }
            // выводим числа каждого игрока и подготавливаем массивы к следующему раунду
            for (Player player : players) {
                setUp(player);
            }
        }
        // определение победителя по результатам раундов
        winnerSelection();
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

    private void setUp(Player player) {
        System.out.println("Числа игрока " + player.getName() + ": " + Arrays.toString(player.getGuessedNumbers()).replaceAll("\\D+", " "));
        player.resetAllNumbers();
        player.setAttempt(0);
    }

    private void lot() {
        System.out.println("Бросаем жребий для определения хода");
        Random r = new Random();
        for (int i = 0; i < 3; i++) {
            orderOfPriority[i] = r.nextInt(15) + 3;    // 18 max, 3 min
            System.out.println("Игрок " + players[i].getName() + " получил: " + orderOfPriority[i] + " очков");
        }
        int indexOfMax = 0;
        int indexOfMin = 0;
        for (int i = 1; i < 3; i++) {
            if (orderOfPriority[i] > orderOfPriority[indexOfMax]) {
                indexOfMax = i;
            } else if (orderOfPriority[i] < orderOfPriority[indexOfMin]) {
                indexOfMin = i;
            }
        }
        int indexOfMid = (6 - ((indexOfMin + 1) + (indexOfMax + 1))) - 1;
        System.out.print("Первым ходит: " + players[indexOfMax].getName());
        System.out.print(". Вторым ходит: " + players[indexOfMid].getName());
        System.out.println(". Третьим ходит: " + players[indexOfMin].getName());
        orderOfPriority[0] = indexOfMax;
        orderOfPriority[1] = indexOfMid;
        orderOfPriority[2] = indexOfMin;
    }

    private void winnerSelection() {
        System.out.print("Победители в трех раундах: ");
        for (String name : winners) {
            System.out.print(name + " ");
        }
        System.out.println("");
        int countPlayer1 = Collections.frequency(List.of(winners),players[0].getName());
        int countPlayer2 = Collections.frequency(List.of(winners),players[1].getName());
        int countPlayer3 = Collections.frequency(List.of(winners),players[2].getName());
        System.out.println("Игрок 1 (" + players[0].getName() + ") выиграл " + countPlayer1 + " раз.");
        System.out.println("Игрок 2 (" + players[1].getName() + ") выиграл " + countPlayer2 + " раз.");
        System.out.println("Игрок 3 (" + players[2].getName() + ") выиграл " + countPlayer3 + " раз.");
        if (countPlayer1 == countPlayer2 & countPlayer1 == countPlayer3) {
            System.out.println("Победителя нет. Победила дружба! :)");
        } else if (countPlayer1 > countPlayer2 & countPlayer1 > countPlayer3) {
            System.out.println("Победил: " + players[0].getName());
        } else if (countPlayer2 > countPlayer1 & countPlayer2 > countPlayer3) {
            System.out.println("Победил: " + players[1].getName());
        } else {
            System.out.println("Победил: " + players[2].getName());
        }
    }
}