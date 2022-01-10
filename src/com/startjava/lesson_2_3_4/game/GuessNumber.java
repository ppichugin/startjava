package com.startjava.lesson_2_3_4.game;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    private int secretNumber;
    private final Player[] player = new Player[3];

    public GuessNumber(Player[] players) {
        this.player[0] = players[0];
        this.player[1] = players[1];
        this.player[2] = players[2];
    }

    public void start() {
        System.out.println("У каждого игрока по 10 попыток.");
        System.out.println("Победитель будет определен по результатам трех раундов! Начинаем!");
        for (int round = 0; round < 3; round++) {       // раунды
            generateSecretNumber();
            System.out.println("\nКомпьютер загадал число.");
            System.out.println("=== РАУНД: " + (round + 1));
            // игроки бросают жребий
            pushTheLot();
            // начало игры
            boolean isNumberGuessed = false;
            for (int i = 0; i < 10; i++) { // попытки
                System.out.println("---- Попытка № " + (i + 1));
                for (Player playerInGame : player) { // ходы участников
                    inputNumber(playerInGame);
                    if (checkNumber(playerInGame)) {
                        isNumberGuessed = true;
                        playerInGame.setNumOfWins(playerInGame.getNumOfWins() + 1);
                        i = 10;
                        break;
                    }
                }
            }
            if (!isNumberGuessed) {
                System.out.println("Никто не угадал число..");
             }
            // выводим числа каждого игрока
            for (Player player : player) {
                System.out.println("Числа игрока " + player.getName() + ": " + Arrays.toString(player.getGuessedNumbers()).replaceAll("\\D+", " "));
            }
            // подготавливаем игроков к следующему раунду
            for (Player player : player) {
                setUp(player);
            }
        }
        // определение победителя по результатам трех раундов
        winnerSelection();
        // сброс количества побед перед новой игрой
        for (Player pls : player) {
            pls.setNumOfWins(0);
        }
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
        if (player.getAttempt() == 10) {
            System.out.println("У " + player.getName() + " закончились попытки");
        } else if (player.getNumber() < secretNumber) {
            System.out.println(player.getName() + ", введенное число '" + player.getNumber() + "' меньше загаданного.");
        } else if (player.getNumber() > secretNumber) {
            System.out.println(player.getName() + ", введенное число '" + player.getNumber() + "' больше загаданного.");
        } else if (player.getNumber() == secretNumber) {
            System.out.printf("%S%s%d%n\n", player.getName(), ", Вы угадали число!!! Это: ", player.getNumber());
            System.out.println("Игрок " + player.getName() + " угадал число " + player.getNumber() + " с " + player.getAttempt() + " попытки");
            return true;
        }
        return false;
    }

    private void setUp(Player player) {
        player.resetAllNumbers();
        player.setAttempt(0);
    }

    private void pushTheLot() {
        System.out.println("Бросаем жребий для определения хода");
        int[] orderOfPriority = new int[3];
        for (int i = 0; i < 3; i++) {
            orderOfPriority[i] = (int) (Math.random() * 6) + 1; // кубик с шестью гранями [1,6]
            System.out.println("Игрок " + player[i].getName() + " получил: " + orderOfPriority[i] + " очков");
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
        System.out.print("Очередность ходов: 1) " + player[indexOfMax].getName());
        System.out.print(" 2) " + player[indexOfMid].getName());
        System.out.println(" 3) " + player[indexOfMin].getName());
        orderOfPriority[0] = indexOfMax;
        orderOfPriority[1] = indexOfMid;
        orderOfPriority[2] = indexOfMin;
        // переопределение порядка игроков в массиве по результатам жребия
        swapPlayers(indexOfMax, indexOfMid, indexOfMin);
    }

    private void winnerSelection() {
        System.out.println();
        for (Player player : player) {
            System.out.println("Игрок (" + player.getName() + ") угадал " + player.getNumOfWins() + " раз.");
        }
        int winnerIndex = 0;
        for (int i = 1; i < player.length - 1; i++) {
            if (player[i].getNumOfWins() > player[winnerIndex].getNumOfWins()) {
                winnerIndex = i;
            }
        }
        if (player[winnerIndex].getNumOfWins() == 0 || (player[0].getNumOfWins() == 1 & player[1].getNumOfWins() == 1 & player[2].getNumOfWins() == 1)) {
            System.out.println("Победителя нет. Победила дружба! :)");
        } else {
            System.out.println("Победил: " + player[winnerIndex].getName());
        }
    }

    private void swapPlayers(int firstPlayer, int secondPlayer, int thirdPlayer) {
        Player[] tempPlayers = new Player[3];
        tempPlayers[0] = player[firstPlayer];
        tempPlayers[1] = player[secondPlayer];
        tempPlayers[2] = player[thirdPlayer];
        System.arraycopy(tempPlayers, 0, player, 0, 3);
    }

}