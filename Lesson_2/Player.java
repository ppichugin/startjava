

public class Player {

    private String name;
    private int minRange = 1;
    private int maxRange = 100;
    private int number;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setMinRange(int minRange) {
        this.minRange = minRange;
    }

    public void setMaxRange(int maxRange) {
        this.maxRange = maxRange;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int corrections() {
        return ((this.minRange + this.maxRange) / 2);
    }

    public void initialization() {
        this.minRange = 1;
        this.maxRange = 100;
        this.number = 0;
    }

    // public boolean checkNumber(int number, int secretNumber) {
    //     this.number = number;
    //     if (number < secretNumber) {
    //         System.out.println("Введенное число: " + number + " меньше загаданного.");
    //         setMinRange(number);
    //         System.out.println("_Подсказка для игрока " + name + " : " + corrections() + "\n");
    //     } else if (number > secretNumber) {
    //         System.out.println("Введенное число: " + number + " больше загаданного.");
    //         setMaxRange(number);
    //         System.out.println("_Подсказка для игрока " + name + " : " + corrections() + "\n");
    //     } else if (number == secretNumber) {
    //         System.out.printf("%S%s%d%n\n", name, ", Вы угадали число!!! Это: ", number);
    //         return true;
    //     }
    //     return false;
    // }
}