package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {

    public static void main(String[] args) {
        Scanner scanInput = new Scanner(System.in);
        String answer = "yes";
        do {
            if ("yes".equals(answer)) {
                outer:
                while (true) {
                    System.out.print("Введите математическое выражение с целыми положительынми числами через пробел: ");
                    String line = scanInput.nextLine();
                    String[] lineCalculation = line.split(" ");
                    Calculator.setMathSign(lineCalculation[1].charAt(0));
                    if (!Calculator.setNumber1(Double.parseDouble(lineCalculation[0])) | !Calculator.setNumber2(Double.parseDouble(lineCalculation[2]))) {
                        continue;
                    } else {
                        break;
                    }
                }
                System.out.println("Результат: " + Calculator.calculate());
            }
            System.out.print("Хотите продолжить вычисления? [yes/no]: ");
            answer = scanInput.nextLine();
        } while (!"no".equals(answer));
        scanInput.close();
    }
}