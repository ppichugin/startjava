public class ConditionalStatement {

    public static void main(String[] args) {
        int age = 22;
        if (age > 20) {
            System.out.println("Возраст " + age + " (лет) больше 20");
        }

        boolean isMale = true;
        if (isMale) {
            System.out.println("Мужской пол.");
        }

        if (!isMale) {
            System.out.println("Женский пол.");
        }

        double height = 1.85;
        if (height < 1.80) {
            System.out.println("Рост - средний или ниже среднего: " + height);
        } else {
            System.out.println("Рост - высокий: " + height);
        }

        char firstLetterOfName = 'M';
        if (firstLetterOfName == 'M') {
            System.out.println("Вариант 1. Первая буква имени: " + firstLetterOfName);
        } else if (firstLetterOfName == 'I') {
            System.out.println("Вариант 2. Первая буква имени: " + firstLetterOfName);
        } else {
            System.out.println("Вариант 3. Первая буква имени вне диапазона проверки: " + firstLetterOfName);
        }
    }
}