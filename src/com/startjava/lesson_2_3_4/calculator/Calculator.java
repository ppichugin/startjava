package com.startjava.lesson_2_3_4.calculator;

public class Calculator {

    private static int number1;
    private static int number2;
    private static char mathSign;

    public static boolean setNumber1(double number1) {
        if (number1 < 0) {
            System.out.println("Введеное первое число отрицательное.");
            return false;
        }
        if (number1 != (int) number1 ) {
            System.out.println("Введеное первое число не целое.");
            return false;
        }
        Calculator.number1 = (int) number1;
        return true;
    }

    public static boolean setNumber2(double number2) {
        if (number2 < 0) {
            System.out.println("Введеное второе число число отрицательное.");
            return false;
        }
        if (number2 != (int) number2) {
            System.out.println("Введеное второе число не целое.");
            return false;
        }
        Calculator.number2 = (int) number2;
        return true;
    }

    public static void setMathSign(char mathSign) {
        Calculator.mathSign = mathSign;
    }

    public static String calculate() {

        String result =
            switch (mathSign) {
                case '+' -> {
                    yield String.valueOf(number1 + number2);
                }
                case '-' -> {
                    yield String.valueOf(number1 - number2);
                }
                case '*' -> {
                    yield String.valueOf(number1 * number2);
                }
                case '/' -> {
                    // используем тип double, чтобы сохранить знаки после запятой
                    yield String.valueOf((double) number1 / (double) number2);
                }
                case '^' -> {
                    // используем тип Long так как возведение в степень может иметь большие значения
                   yield String.valueOf((long) Math.pow(number1, number2));
                }
                case '%' -> {
                    yield String.valueOf(number1 % number2);
                }
                default -> "Математическая операция невозможна. Недопустимый оператор.";
            };
        return result;
    }
}