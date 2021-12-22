import java.util.Scanner;

public class GuessNumberTest {

    public static void main(String[] args) {
        Scanner scanInput = new Scanner(System.in);
        System.out.print("Введите имя первого игрока. PLAYER 1: ");
        String playerOneName = scanInput.nextLine();
        Player playerOne = new Player(playerOneName);
        System.out.print("Введите имя второго игрока. PLAYER 2: ");
        String playerTwoName = scanInput.nextLine();
        Player playerTwo = new Player(playerTwoName);
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