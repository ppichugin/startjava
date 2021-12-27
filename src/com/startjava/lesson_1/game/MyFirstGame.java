package com.startjava.lesson_1.game;

public class MyFirstGame {

    public static void main(String[] args) {
        // "загадываем" число в диапазоне [0, 100]
        int minRange = 0;
        int maxRange = 100;
        int targetNumber = 10;
        int playerAnswer = 50;
        do {
            if (playerAnswer > targetNumber) {
                System.out.println("Данное число (" + playerAnswer + ") больше того, что загадал компьютер");
                // сокращаем верхний диапазон поиска
                maxRange = playerAnswer;
                playerAnswer = (minRange + maxRange) / 2;
            } else if (playerAnswer < targetNumber) {
                System.out.println("Данное число (" + playerAnswer + ") меньше того, что загадал компьютер");
                // повышаем нижний диапазон поиска
                minRange = playerAnswer;
                playerAnswer = (minRange + maxRange + 1) / 2;
            }
        } while (playerAnswer != targetNumber);
        System.out.println("Поздравляю, число угадано! " + playerAnswer);
    }
}