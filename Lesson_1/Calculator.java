public class Calculator {

    public static void main(String[] args) {
        // определяем переменную с заданием на вычисление
        String taskToCalculate = "  50 / 100";
        System.out.println("Начальное задание: " + taskToCalculate);
        // вычисляем длину строки для цикла
        int lenTask = taskToCalculate.length();
        // определяем переменные для последующего хранения цифр и математической операции
        char symbolOfOperation = ' ';
        String number1 = "";
        char charSearch;
        int position = 0;
        // находим знак математической операции и первую цифру
        for (int i = 0; i < lenTask; i++) {
            charSearch = taskToCalculate.charAt(i);
            // поиск (+, -, *, /, ^, %) и определение его положения
            if (charSearch == '+' || charSearch == '-' || charSearch == '*' || charSearch == '/' || charSearch == '^' || charSearch == '%') {
                position = i;
                symbolOfOperation = charSearch;
                break;
            // если недопустимый математический оператор
            } else if (!Character.isDigit(charSearch) && !Character.isWhitespace(charSearch)) {
                System.out.println(charSearch + " в позиции " + i + " является неверным оператором");
                symbolOfOperation = '~';
                position = i;
                break;
            // если символ является цифровым значением, то собираем его в переменную для первой цифры
            } else if (Character.isDigit(charSearch)) {
                number1 = number1 + Character.toString(charSearch);
            }
        }
        System.out.println("Первая цифра: " + number1);
        if (symbolOfOperation != '~') {
            System.out.println("Знак математической операции: " + symbolOfOperation);
        }
        // начинаем цикл со следующего символа и собираем вторую цифру
        String number2 = "";
        for (int i = position + 1; i < lenTask; i++) {
            charSearch = taskToCalculate.charAt(i);
            if (Character.isDigit(charSearch)) {
                number2 = number2 + Character.toString(charSearch);
            }
        }
        System.out.println("Вторая цифра: " + number2);
        // выполняем операции (+, -, *, /, ^, %)
        double result = 0;
        switch (symbolOfOperation) {
            case '+':
                System.out.println("Выполняем сложение");
                result = Integer.parseInt(number1) + Integer.parseInt(number2);
                System.out.println(number1 + " + " + number2 + " = " + result);
                break;

            case '-':
                System.out.println("Выполняем вычитание");
                result = Integer.parseInt(number1) - Integer.parseInt(number2);
                System.out.println(number1 + " - " + number2 + " = " + result);
                break;

            case '*':
                System.out.println("Выполняем умножение");
                result = Integer.parseInt(number1) * Integer.parseInt(number2);
                System.out.println(number1 + " * " + number2 + " = " + result);
                break;

            case '/':
                System.out.println("Выполняем деление");
                // тип String переводим в Double чтобы не потерять результат после запятой,
                // так как результат может быть не целочисленный
                result = Double.parseDouble(number1) / Double.parseDouble(number2);
                System.out.println(number1 + " / " + number2 + " = " + result);
                break;

            case '^':
                System.out.println("Выполняем возведение в степень");
                // используем тип Long так как возведение в степень может иметь большие значения
                long resultLong = 1;
                for (int j = 1; j <= Integer.parseInt(number2); j++) {
                    resultLong = resultLong * Long.parseLong(number1);
                }
                System.out.println(number1 + " ^ " + number2 + " = " + resultLong);
                break;

            case '%':
                System.out.println("Выполняем деление по модулю");
                result = Integer.parseInt(number1) % Integer.parseInt(number2);
                System.out.println(number1 + " % " + number2 + " = " + result);
                break;

            default:
                System.out.println("Математическая операция невозможна. Недопустимый оператор.");
                break;
        }
    }
}