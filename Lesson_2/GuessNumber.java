import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    private static int secretNumber;
    private static int numberPlayerOne;
    private static int numberPlayerTwo;

    public static void Start(String playerOneName, String playerTwoName) {
        Player playerOne = new Player(playerOneName);
        Player playerTwo = new Player(playerTwoName);
        Scanner scanInput = new Scanner(System.in);
        GuessNumber.ComputerNumber();
        System.out.println("Компьютер загадал число.");
        System.out.println("GAME STARTS! Всем пристегнуться!");
        while (true) {
            System.out.print("PLAYER 1: " + playerOne.getName() + " введите Ваше число: ");
            numberPlayerOne = scanInput.nextInt();
            System.out.print("PLAYER 2: " + playerTwo.getName() + " введите Ваше число: ");
            numberPlayerTwo = scanInput.nextInt();

            if (numberPlayerOne < secretNumber) {
                System.out.println("введенное число игрока 1: " + numberPlayerOne + " меньше загаданного.");
                playerOne.setMinRange(numberPlayerOne);
                System.out.println("Подсказка для игрока 1: " + playerOne.Corrections() + "\n");
            } else if (numberPlayerOne > secretNumber) {
                System.out.println("введенное число игрока 1: " + numberPlayerOne + " больше загаданного.");
                playerOne.setMaxRange(numberPlayerOne);
                System.out.println("Подсказка для игрока 1: " + playerOne.Corrections() + "\n");
            } else if (numberPlayerOne == secretNumber) {
                System.out.println("PLAYER 1 " + playerOne.getName() + " угадал число!!! " + numberPlayerOne + " = " + secretNumber);
                break;
            }

            if (numberPlayerTwo < secretNumber) {
                System.out.println("введенное число игрока 2: " + numberPlayerTwo + " меньше загаданного.");
                playerTwo.setMinRange(numberPlayerTwo);
                System.out.println("Подсказка для игрока 2: " + playerTwo.Corrections() + "\n");
            } else if (numberPlayerTwo > secretNumber) {
                System.out.println("введенное число игрока 2 " + numberPlayerTwo + " больше загаданного.");
                playerTwo.setMaxRange(numberPlayerTwo);
                System.out.println("Подсказка для игрока 2: " + playerTwo.Corrections() + "\n");
            } else if (numberPlayerTwo == secretNumber) {
                System.out.println("PLAYER 2 " + playerTwo.getName() + " угадал число!!! " + numberPlayerTwo + " = " + secretNumber);
                break;
            }
        }
    }

    public static void ComputerNumber() {
        Random r = new Random();
        secretNumber = r.nextInt(100) + 1;
    }

}