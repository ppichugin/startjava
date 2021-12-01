public class MyFirstGame {

    public static void main(String[] args) {
        // "загадываем" число в диапазоне [0, 100]
        int numberMin = 0;
        int numberMax = 100;
        int numberFromComputer = 1;
        int numberFromPlayer = 50;
        do {
            if (numberFromPlayer > numberFromComputer) {
                System.out.println("Данное число (" + numberFromPlayer + ") больше того, что загадал компьютер");
                // сокращаем верхний диапазон поиска
                numberMax = numberFromPlayer;
                numberFromPlayer = (numberMin + numberMax) / 2;
            } else if (numberFromPlayer < numberFromComputer) {
                System.out.println("Данное число (" + numberFromPlayer + ") меньше того, что загадал компьютер");
                // повышаем нижний диапазон поиска
                numberMin = numberFromPlayer;
                numberFromPlayer = (numberMin + numberMax + 1) / 2;
            }
        } while (numberFromPlayer != numberFromComputer);
        System.out.println("Поздравляю, число угадано! " + numberFromPlayer);
    }
}