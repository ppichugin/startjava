public class Cycle {

    public static void main(String[] args) {

        int i; // определяем переменную для счетчика циклов
        System.out.println("Д/З по циклам.");
        System.out.println("Часть 1. Вывести все числа используя цикл for от 0 до 20:");
        for (i = 0; i <= 20; i++) {
            System.out.print(i + " ");
        }

        System.out.println(" " + '\n');
        System.out.println("Часть 2. Вывести все числа используя цикл while от [6, -6] (с шагом итерации 2)");
        i = 6;
        while (i >= -6) {
            System.out.print(i + " ");
            i = i - 2;
        }

        i = 10; // устанавливаем начальное значение для цикла
        int lastNumber = 20; // конечное значение цикла, чтобы унифицировать алгоритм
        int oddSumNumbers = 0;
        System.out.println(" " + '\n');
        System.out.println("Часть 3. Подсчитать сумму нечетных чисел используя цикл do-while в диапазоне [" + i +", " + lastNumber +"]");
        do {
            if (i % 2 == 1) {
                System.out.print(i);
                oddSumNumbers = oddSumNumbers + i;
                    // если это последнее значение выборки, то ставим "=", иначе ставим "+" между цифрами
                    if (i == lastNumber | i == lastNumber - 1) {
                        System.out.print(" = ");
                    } else {
                        System.out.print(" + ");
                    }
            }
        i++;
        } while (i <= lastNumber);
        System.out.print(oddSumNumbers);
    }
}