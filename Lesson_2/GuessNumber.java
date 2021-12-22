import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    private int secretNumber;
    private Player playerOne;
    private Player playerTwo;

    public GuessNumber(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void start() {
        generateSecretNumber();
        System.out.println("Компьютер загадал число. Начинаем игру !");
        while (true) {
            System.out.println("-----");
            getNumberFromPlayer(playerOne);
            getNumberFromPlayer(playerTwo);
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
            System.out.println(player.getName() + ", введенное число '" + player.getNumber() + "' меньше загаданного.");
        } else if (player.getNumber() > secretNumber) {
            System.out.println(player.getName() + ", введенное число '" + player.getNumber() + "' больше загаданного.");
        } else if (player.getNumber() == secretNumber) {
            System.out.printf("%S%s%d%n\n", player.getName(), ", Вы угадали число!!! Это: ", player.getNumber());
            return true;
        }
        return false;
    }

    private void getNumberFromPlayer(Player player) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(player.getName() + ", введите число [1, 100]: ");
            if (player.setNumber(sc.nextInt())) {
                break;
            }
        }
    }

}