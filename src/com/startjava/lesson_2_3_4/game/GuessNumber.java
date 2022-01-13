package com.startjava.lesson_2_3_4.game;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    private final Player[] players = new Player[3];
    private int secretNumber;

    public GuessNumber(Player[] players) {
        this.players[0] = players[0];
        this.players[1] = players[1];
        this.players[2] = players[2];
    }

    public void start() {
        System.out.println("У каждого игрока по 10 попыток.");
        System.out.println("Победитель будет определен по результатам трех раундов! Начинаем!");
        boolean isLastRound = false;
        for (int round = 0; round < 3; round++) {
            generateSecretNumber();
            System.out.println("\nКомпьютер загадал число.");
            System.out.println("=== РАУНД: " + (round + 1));
            // игроки бросают жребий
            castLot();
            // начало игры
            startGameplay();
            // выводим числа каждого игрока
            printPlayerNumbers();
            // подготавливаем игроков к следующему раунду
            setUp(isLastRound);
        }
        isLastRound = true;
        // определение победителя по результатам трех раундов
        chooseWinner();
        // сброс количества побед перед новой игрой
        setUp(isLastRound);
    }

    private void generateSecretNumber() {
        Random r = new Random();
        secretNumber = r.nextInt(100) + 1;
    }

    private void castLot() {
        System.out.println("Бросаем жребий для определения хода");
        int[] orderOfPriority = new int[3];
        for (int i = 0; i < 3; i++) {
            // кубик с шестью гранями [1,6]
            orderOfPriority[i] = (int) (Math.random() * 6) + 1;
            System.out.println("Игрок " + players[i].getName() + " получил: " + orderOfPriority[i] + " очков");
        }
        int indexOfMax = 0;
        int indexOfMin = 0;
        int indexOfMid;
        if (orderOfPriority[0] == orderOfPriority[1] && orderOfPriority[1] == orderOfPriority[2]) {
            indexOfMid = 1;
            indexOfMin = 2;
        } else {
            for (int i = 1; i < 3; i++) {
                if (orderOfPriority[i] > orderOfPriority[indexOfMax]) {
                    indexOfMax = i;
                } else if (orderOfPriority[i] < orderOfPriority[indexOfMin]) {
                    indexOfMin = i;
                }
            }
            indexOfMid = (6 - ((indexOfMin + 1) + (indexOfMax + 1))) - 1;
        }
        System.out.print("Очередность ходов: 1) " + players[indexOfMax].getName());
        System.out.print(" 2) " + players[indexOfMid].getName());
        System.out.println(" 3) " + players[indexOfMin].getName());
        orderOfPriority[0] = indexOfMax;
        orderOfPriority[1] = indexOfMid;
        orderOfPriority[2] = indexOfMin;
        // переопределяем порядок игроков в массиве по результатам жребия
        swapPlayers(players[indexOfMax], players[indexOfMid], players[indexOfMin]);
    }

    private void startGameplay() {
        boolean isNumberGuessed = false;
        for (int i = 0; i < 10; i++) { // попытки
            System.out.println("---- Попытка № " + (i + 1));
            for (Player currentPlayer : players) { // ходы участников
                inputNumber(currentPlayer);
                if (compareNumbers(currentPlayer)) {
                    isNumberGuessed = true;
                    currentPlayer.increaseWinsForOne();
                    i = 10;
                    break;
                }
                if (currentPlayer.getAttempt() == 10) {
                    System.out.println("У " + currentPlayer.getName() + " закончились попытки");
                }
            }
        }
        if (!isNumberGuessed) {
            System.out.println("Никто не угадал число..");
        }
    }

    private void printPlayerNumbers() {
        for (Player player : players) {
            System.out.print("Числа игрока " + player.getName() + ": ");
            for (int num : player.getGuessedNumbers()) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private void setUp(boolean isLastRound) {
        if (!isLastRound) {
            // обнуляем массив чисел и число попыток
            for (Player player : players) {
                player.resetAllNumbers();
                player.setAttempt(0);
            }
        } else {
            // обнуляем число побед
            for (Player player : players) {
                player.setWin(0);
            }
        }
    }

    private void chooseWinner() {
        System.out.println();
        for (Player player : players) {
            System.out.println("Игрок '" + player.getName() + "' угадал " + player.getNumOfWins() + " раз.");
        }
        int winnerIndex = 0;
        int winnersCounter = 0;
        // поиск победителя и подсчет одинаковых чисел (ничьих).
        for (int i = 0; i < players.length; i++) {
            if (players[i].getNumOfWins() == players[winnerIndex].getNumOfWins()) {
                winnersCounter++;
            } else if (players[i].getNumOfWins() > players[winnerIndex].getNumOfWins()) {
                winnerIndex = i;
            }
        }
        if (winnersCounter == 3) {
            System.out.println("Победителя нет. Победила дружба! :)");
        } else if (winnersCounter == 2) {
            System.out.print("Победили два игрока: ");
            for (Player player : players) {
                if (player.getNumOfWins() == players[winnerIndex].getNumOfWins()) {
                    System.out.print("'" + player.getName() + "' ");
                }
            }
            System.out.println();
        } else {
            System.out.println("Победил: " + players[winnerIndex].getName());
        }
    }

    private void inputNumber(Player player) {
        Scanner sc = new Scanner(System.in);
        boolean isNumberValid;
        do {
            System.out.print(player.getName() + ", введите число [1, 100]: ");
            isNumberValid = player.setNumber(sc.nextInt());
        } while (!isNumberValid);
        player.increaseAttemptsForOne();
    }

    private boolean compareNumbers(Player player) {
        if (player.getNumber() < secretNumber) {
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

    private void swapPlayers(Player firstPlayer, Player secondPlayer, Player thirdPlayer) {
        players[0] = firstPlayer;
        players[1] = secondPlayer;
        players[2] = thirdPlayer;
    }
}