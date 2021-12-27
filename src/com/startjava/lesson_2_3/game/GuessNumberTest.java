package com.startjava.lesson_2_3.game;

import java.util.Scanner;

public class GuessNumberTest {

    public static void main(String[] args) {
        Scanner scanInput = new Scanner(System.in);
        System.out.print("Введите имя первого игрока. PLAYER 1: ");
        Player playerOne = new Player(scanInput.nextLine());

        System.out.print("Введите имя второго игрока. PLAYER 2: ");
        Player playerTwo = new Player(scanInput.nextLine());
        GuessNumber game = new GuessNumber(playerOne, playerTwo);
        String answer ="yes";
        do {
            if("yes".equals(answer)) {
                game.start();
            }
            System.out.print("Хотите продолжить игру? [yes/no]: ");
            answer = scanInput.nextLine();
        } while(!"no".equals(answer));
        scanInput.close();
    }
}