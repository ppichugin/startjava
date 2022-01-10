package com.startjava.lesson_2_3_4.game;

import java.util.Arrays;

public class Player {

    private String name;
    private int[] numbers = new int[10];
    private int attempt;
    private int numOfWins;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean setNumber(int number) {
        if (number < 1 || number > 100) {
            System.out.println("Введеное число вне допустимого диапазона.");
            return false;
        }
        numbers[attempt] = number;
        return true;
    }

    public int getNumber() {
        return numbers[attempt - 1];
    }

    public int getAttempt() {
        return attempt;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }

    public int getNumOfWins() {
        return numOfWins;
    }

    public void setWin(int numOfWins) {
        this.numOfWins = numOfWins;
    }

    public int[] getGuessedNumbers() {
        return Arrays.copyOf(numbers, attempt);
    }

    public void resetAllNumbers() {
        Arrays.fill(numbers, 0, attempt, 0);
    }
}