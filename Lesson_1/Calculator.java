public class Calculator {

    public static void main(String[] args) {
        // определяем переменные для цифр и математической операции (+, -, *, /, ^, %)
        int number1 = 175;
        int number2 = 21;
        char symbolOfOperation = '%';
        System.out.println("Задание: " + number1 + " " + symbolOfOperation + " " + number2);
        double result = 0;
        switch (symbolOfOperation) {
            case '+':
                System.out.println("Выполняем сложение");
                result = number1 + number2;
                System.out.println(number1 + " + " + number2 + " = " + (int) result);
                break;

            case '-':
                System.out.println("Выполняем вычитание");
                result = number1 - number2;
                System.out.println(number1 + " - " + number2 + " = " + (int) result);
                break;

            case '*':
                System.out.println("Выполняем умножение");
                result = number1 * number2;
                System.out.println(number1 + " * " + number2 + " = " + (int) result);
                break;

            case '/':
                System.out.println("Выполняем деление");
                result = number1 / number2;
                System.out.println(number1 + " / " + number2 + " = " + result);
                break;

            case '^':
                System.out.println("Выполняем возведение в степень");
                // используем тип Long так как возведение в степень может иметь большие значения
                long resultLong = 1;
                for (int j = 1; j <= number2; j++) {
                    resultLong = resultLong * number1;
                }
                System.out.println(number1 + " ^ " + number2 + " = " + resultLong);
                break;

            case '%':
                System.out.println("Выполняем деление по модулю");
                result = number1 % number2;
                System.out.println(number1 + " % " + number2 + " = " + (int) result);
                break;

            default:
                System.out.println("Математическая операция невозможна. Недопустимый оператор.");
                break;
        }
    }
}