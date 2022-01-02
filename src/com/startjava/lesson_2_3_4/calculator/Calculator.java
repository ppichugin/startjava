package com.startjava.lesson_2_3_4.calculator;

public class Calculator {

    private static int number1;
    private static int number2;
    private static char mathSign;

    public static boolean setNumber1(double number1) {
        if (number1 < 0) {
            System.out.print("Введенное первое число отрицательное! ");
            return false;
        } else if (number1 != (int) number1 ) {
            System.out.print("Введенное первое число не целое! ");
            return false;
        }
        Calculator.number1 = (int) number1;
        return true;
    }

    public static boolean setNumber2(double number2) {
        if (number2 < 0) {
            System.out.print("Введенное второе число число отрицательное! ");
            return false;
        } else if (number2 != (int) number2) {
            System.out.print("Введенное второе число не целое! ");
            return false;
        }
        Calculator.number2 = (int) number2;
        return true;
    }

    public static void setMathSign(char mathSign) {
        Calculator.mathSign = mathSign;
    }

    public static double calculate(String mathOperation) {
        String[] lineCalculation = mathOperation.split(" ");
        Calculator.setMathSign(lineCalculation[1].charAt(0));
        if (!Calculator.setNumber1(Double.parseDouble(lineCalculation[0])) | !Calculator.setNumber2(Double.parseDouble(lineCalculation[2]))) {
            return -100;
        }
        return switch (mathSign) {
            case '+' -> number1 + number2;
            case '-' -> number1 - number2;
            case '*' -> number1 * number2;
            case '/' -> (double) number1 / (double) number2;
            case '^' -> Math.pow(number1, number2);
            case '%' -> number1 % number2;
            default -> {
                System.out.println("Введен недопустимый оператор математической операции!");
                yield -100;
            }
        };
    }
}