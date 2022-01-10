package com.startjava.lesson_2_3_4.game;

import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        Player[] players = new Player[3];
        Scanner scanInput = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.print("Введите имя игрока " + (i + 1) + ": ");
            players[i] = new Player(scanInput.nextLine());
        }
        GuessNumber game = new GuessNumber(players);
        String answer ="yes";
        do {
            if ("yes".equals(answer)) {
                game.start();
            }
            System.out.print("Хотите продолжить игру? [yes/no]: ");
            answer = scanInput.nextLine();
        } while (!"no".equals(answer));
        scanInput.close();
    }
}