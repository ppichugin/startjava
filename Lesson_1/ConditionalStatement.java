public class ConditionalStatement {

    public static void main(String[] args) {

        // https://github.com/ichimax/startjava/blob/master/lesson%201.md#-7-ветвление-if-if-else
        int age = 22;
        boolean isMale = true;
        double height = 1.85;
        char firstLetterOfName = 'M';

            if (age > 20) {
                System.out.println("Возраст " + age + " (лет) больше 20");
            }

            if (isMale) {
                System.out.println("Мужской пол.");
            }

            if (!isMale) {
                System.out.println("Женский пол.");
            }

            if (height < 1.80) {
                System.out.println("Рост - средний или ниже среднего: " + height);
            } else {
                System.out.println("Рост - высокий: " + height);
            }

            if (firstLetterOfName == 'M') {
                System.out.println("Вариант 1. Первая буква имени: " + firstLetterOfName);
            } else if (firstLetterOfName == 'I') {
                System.out.println("Вариант 2. Первая буква имени: " + firstLetterOfName);
            } else {
                System.out.println("Вариант 3. Первая буква имени вне диапазона проверки: " + firstLetterOfName);
            }
    }
}