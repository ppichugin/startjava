package com.startjava.lesson_2_3.calculator;

public class Calculator {

    private int number1;
    private int number2;
    private char mathSign;

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public void setMathSign(char mathSign) {
        this.mathSign = mathSign;
    }

    public void calculate() {
        System.out.print("Задание: " + number1 + mathSign + number2);
        switch (mathSign) {
            case '+':
                System.out.println(" = " + (number1 + number2));
                break;
            case '-':
                System.out.println(" = " + (number1 - number2));
                break;
            case '*':
                System.out.println(" = " + (number1 * number2));
                break;
            case '/':
                // используем тип double, чтобы сохранить знаки после запятой
                System.out.println(" = " + ((double) number1 / (double) number2));
                break;
            case '^':
                // используем тип Long так как возведение в степень может иметь большие значения
                long resultExponentiaton = 1;
                for (int j = 1; j <= number2; j++) {
                    resultExponentiaton *= number1;
                }
                System.out.println(" = " + resultExponentiaton);
                break;
            case '%':
                System.out.println(" = " + (number1 % number2));
                break;
            default:
                System.out.println("\n" + "Математическая операция невозможна. Недопустимый оператор.");
                break;
        }
    }
}