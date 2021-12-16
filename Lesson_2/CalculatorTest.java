import java.util.Scanner;

public class CalculatorTest {

    public static void main(String[] args) {
        Scanner scanInput = new Scanner(System.in);
        Calculator calc = new Calculator();
        String answer = "yes";
        do {
            if ("yes".equals(answer)) {
                System.out.println("Введите первое число: ");
                calc.setNumber1(scanInput.nextInt());
                System.out.println("Введите знак математической операции: ");
                calc.setMathSign(scanInput.next().charAt(0));
                System.out.println("Введите второе число: ");
                calc.setNumber2(scanInput.nextInt());
                scanInput.nextLine();
                calc.calculate();
            }
            System.out.println("Хотите продолжить вычисления? [yes/no]:");
            answer = scanInput.nextLine();
        } while (!"no".equals(answer));
        scanInput.close();
    }
}