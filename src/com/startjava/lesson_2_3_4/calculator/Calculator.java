package com.startjava.lesson_2_3_4.calculator;

import static java.lang.Double.MIN_VALUE;

public class Calculator {

    private static int number1;
    private static int number2;
    private static char mathSign;

    public static boolean setNumber1(double number1) {
        if (checkNumbers(number1)) {
            Calculator.number1 = (int) number1;
            return true;
        }
        return false;
    }

    public static boolean setNumber2(double number2) {
        if (checkNumbers(number2)) {
            Calculator.number2 = (int) number2;
            return true;
        }
        return false;
    }

    private static boolean checkNumbers(double number) {
        if (number < 0) {
            System.out.print("Вы ввели отрицательное число! ");
            return false;
        } else if (number != (int) number) {
            System.out.print("Вы ввели не целое число! ");
            return false;
        }
        return true;
    }

    public static void setMathSign(char mathSign) {
        Calculator.mathSign = mathSign;
    }

    public static double calculate(String mathOperation) {
        String[] separatedExpression = mathOperation.split(" ");
        Calculator.setMathSign(separatedExpression[1].charAt(0));
        // устанавливаем числа и получаем логический результат проверки валидации
        boolean firstNumber = Calculator.setNumber1(Double.parseDouble(separatedExpression[0]));
        boolean secondNumber = Calculator.setNumber2(Double.parseDouble(separatedExpression[2]));
        // если установка одного из чисел не выполнена, то возвращаем константу double MIN_VALUE
        if (!firstNumber | !secondNumber) {
            return MIN_VALUE;
        }
        return switch (mathSign) {
            case '+' -> number1 + number2;
            case '-' -> number1 - number2;
            case '*' -> number1 * number2;
            case '/' -> (double) number1 / (double) number2;
            case '^' -> Math.pow(number1, number2);
            case '%' -> number1 % number2;
            default -> {
                System.out.print("Введен недопустимый оператор математической операции! ");
                yield MIN_VALUE;
            }
        };
    }
}