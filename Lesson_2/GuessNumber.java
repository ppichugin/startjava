import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    private int secretNumber;
    private Player playerOne;
    private Player playerTwo;
    private int number;

    public GuessNumber(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void start() {
        generateSecretNumber();
        playerOne.initialization();
        playerTwo.initialization();
        System.out.println("Компьютер загадал число. Начинаем игру !\n");
        while (true) {
            getNumAndCheckForRange(playerOne);
            getNumAndCheckForRange(playerTwo);
            if (checkNumber(playerOne, secretNumber)) {
                break;
            }
            if (checkNumber(playerTwo, secretNumber)) {
                break;
            }
        }
    }

    private void generateSecretNumber() {
        Random r = new Random();
        secretNumber = r.nextInt(100) + 1;
    }

    private boolean checkNumber(Player player, int secretNumber) {
         if (player.getNumber() < secretNumber) {
            System.out.println("Введенное число: " + player.getNumber() + " меньше загаданного.");
            player.setMinRange(player.getNumber());
            System.out.println("_Подсказка для игрока " + player.getName() + " : " + player.corrections() + "\n");
        } else if (player.getNumber() > secretNumber) {
            System.out.println("Введенное число: " + player.getNumber() + " больше загаданного.");
            player.setMaxRange(player.getNumber());
            System.out.println("_Подсказка для игрока " + player.getName() + " : " + player.corrections() + "\n");
        } else if (player.getNumber() == secretNumber) {
            System.out.printf("%S%s%d%n\n", player.getName(), ", Вы угадали число!!! Это: ", player.getNumber());
            return true;
        }
        return false;
    }

    private void getNumAndCheckForRange(Player player) {
        Scanner sc = new Scanner(System.in);
         while (true) {
            System.out.print(player.getName() + ", введите число [1, 100]: ");
            number = sc.nextInt();
            if (number < 1 | number > 100) {
                System.out.println("Введеное число вне допустимого диапазона.");
                continue;
            } else {
                player.setNumber(number);
                break;
            }
        }
    }

}