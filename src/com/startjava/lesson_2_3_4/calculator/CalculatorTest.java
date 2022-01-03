package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;
import static java.lang.Double.MIN_VALUE;

public class CalculatorTest {

    public static void main(String[] args) {
        Scanner scanInput = new Scanner(System.in);
        String answer = "yes";
        double result;
        do {
            if ("yes".equals(answer)) {
                System.out.print("Введите математическое выражение с целыми положительными числами через пробел: ");
                result = Calculator.calculate(scanInput.nextLine());
                if (result == MIN_VALUE) {
                    System.out.println("Повторите ввод.");
                    continue;
                }
                System.out.println("Результат: " + result);
            }
            System.out.print("Хотите продолжить вычисления? [yes/no]: ");
            answer = scanInput.nextLine();
        } while (!"no".equals(answer));
        scanInput.close();
    }
}