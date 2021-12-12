import java.util.Scanner;

public class CalculatorTest {

    public static void main(String[] args) {
        Scanner scanInput = new Scanner(System.in);
        Scanner scanCheck = new Scanner(System.in);
        boolean continueCalculation = true;
        String answer ="";
        while (continueCalculation) {
            System.out.println("Введите первое число: ");
            int num1 = scanInput.nextInt();
            System.out.println("Введите знак математической операции число: ");
            char sign = scanInput.next().charAt(0);
            System.out.println("Введите второе число: ");
            int num2 = scanInput.nextInt();
            Calculator calcOne = new Calculator();
            calcOne.setNumber1(num1);
            calcOne.setNumber2(num2);
            calcOne.setMathSign(sign);
            calcOne.calc();
            do {
                System.out.println("Хотите продолжить вычисления? [yes/no]:");
                answer = scanCheck.nextLine();
                if (answer.equals("yes") | answer.equals("no")) {
                    break;
                }
            } while (true);
            if (answer.equals("no")) {
                continueCalculation = false;
            }
        }

    }
}