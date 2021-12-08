public class WolfTest {

    public static void main(String[] args) {
        Wolf wolfOne = new Wolf();
        wolfOne.isMale = true;
        wolfOne.name = "Джэк";
        wolfOne.weight = 20.5f;
        wolfOne.age = 12;
        wolfOne.color = "серый";
        System.out.println("КАРТОТЕКА");
        System.out.println("Кличка: " + wolfOne.name);
        System.out.println("Пол: " + (wolfOne.isMale ? "самец" : "самка"));
        System.out.println("Вес: " + wolfOne.weight);
        System.out.println("Возраст: " + wolfOne.age);
        System.out.println("Окрас: " + wolfOne.color);
        System.out.println("ЧТО МОЖЕТ " + wolfOne.name);
        wolfOne.move();
        wolfOne.seat();
        wolfOne.run();
        wolfOne.howl();
        wolfOne.hunt();
    }
}