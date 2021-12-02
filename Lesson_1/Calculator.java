public class Calculator {

    public static void main(String[] args) {
        // определяем переменные для цифр и математической операции (+, -, *, /, ^, %)
        int number1 = 17;
        int number2 = 21;
        char mathSign = '/';
        System.out.println("Задание: " + number1 + " " + mathSign + " " + number2);
        double result = 0;
        switch (mathSign) {
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
                result = (double)number1 / (double)number2;
                System.out.println(number1 + " / " + number2 + " = " + result);
                break;
            case '^':
                System.out.println("Выполняем возведение в степень");
                // используем тип Long так как возведение в степень может иметь большие значения
                long resultDivision = 1;
                for (int j = 1; j <= number2; j++) {
                    resultDivision *= number1;
                }
                System.out.println(number1 + " ^ " + number2 + " = " + resultDivision);
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