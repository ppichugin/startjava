package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {

    public static void main(String[] args) {
        Scanner scanInput = new Scanner(System.in);
        String answer = "yes";
        double result;
        do {
            if ("yes".equals(answer)) {
                System.out.print("Введите математическое выражение с целыми положительными числами через пробел: ");
                String line = scanInput.nextLine();
                result = Calculator.calculate(line);
                if (result == -100) {
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