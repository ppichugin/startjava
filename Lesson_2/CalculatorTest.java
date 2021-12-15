import java.util.Scanner;

public class CalculatorTest {

    public static void main(String[] args) {
        Scanner scanInput = new Scanner(System.in);
        String answer = "yes";
        outer:
        while (true) {
            if (!(answer.equals("yes") | answer.equals("no"))) {
                System.out.println("Хотите продолжить вычисления? [yes/no]:");
                answer = scanInput.nextLine();
                continue outer;
            } else if (answer.equals("no")) {
                break;
            }
            Calculator calc = new Calculator();
            System.out.println("Введите первое число: ");
            calc.setNumber1(scanInput.nextInt());
            System.out.println("Введите знак математической операции: ");
            calc.setMathSign(scanInput.next().charAt(0));
            System.out.println("Введите второе число: ");
            calc.setNumber2(scanInput.nextInt());
            scanInput.nextLine();
            calc.calc();
            System.out.println("Хотите продолжить вычисления? [yes/no]:");
            answer = scanInput.nextLine();
/*            do {
                System.out.println("Хотите продолжить вычисления? [yes/no]:");
                answer = scanInput.nextLine();
            } while (!(answer.equals("yes") | answer.equals("no")));*/
        }
        scanInput.close();
    }
}