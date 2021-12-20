import java.util.Random;

public class GuessNumber {

    int secretNumber;
    int numberPlayerOne;
    int numberPlayerTwo;
    Player playerOne;
    Player playerTwo;

    public GuessNumber(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void start() {
        computerNumber();
        playerOne.initialization();
        playerTwo.initialization();
        System.out.println("Компьютер загадал число. Начинаем игру !\n");
        while (true) {
            playerOne.setNumber();
            numberPlayerOne = playerOne.getNumber();
            playerTwo.setNumber();
            numberPlayerTwo = playerTwo.getNumber();
            if (playerOne.checkNumber(numberPlayerOne, secretNumber)) {
                break;
            }
            if (playerTwo.checkNumber(numberPlayerTwo, secretNumber)) {
                break;
            }
        }
    }

    public void computerNumber() {
        Random r = new Random();
        secretNumber = r.nextInt(100) + 1;
    }

}