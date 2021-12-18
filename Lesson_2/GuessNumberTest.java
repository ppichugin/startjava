import java.util.Scanner;

public class GuessNumberTest {

    public static void main(String[] args) {
        Scanner scanInput = new Scanner(System.in);
        System.out.print("Введите имя первого игрока: ");
        String playerOneName = scanInput.nextLine();
        System.out.print("Введите имя второго игрока: ");
        String playerTwoName = scanInput.nextLine();
        String answer ="yes";
        do {
            if("yes".equals(answer)) {
                GuessNumber.Start(playerOneName, playerTwoName);
            }
            System.out.print("Хотите продолжить игру? [yes/no]: ");
            answer = scanInput.nextLine();
        } while(!"no".equals(answer));
        scanInput.close();
    }
}