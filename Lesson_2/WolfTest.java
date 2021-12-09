public class WolfTest {

    public static void main(String[] args) {
        Wolf wolfOne = new Wolf();
        wolfOne.setMale(true);
        wolfOne.setName("Джэк");
        wolfOne.setWeight(20.5f);
        wolfOne.setAge(7);
        wolfOne.setColor("серый");
        System.out.println("КАРТОТЕКА");
        System.out.println("Кличка: " + wolfOne.getName());
        System.out.println("Пол: " + (wolfOne.isMale() ? "самец" : "самка"));
        System.out.println("Вес: " + wolfOne.getWeight());
        System.out.println("Возраст: " + wolfOne.getAge());
        /* альтернативный вариант с форматированием вывода
        System.out.println("Возраст: " + ((wolfOne.getAge()) == 0 ? wolfOne.getAge() + " (проверьте возраст)" : wolfOne.getAge()));*/
        System.out.println("Окрас: " + wolfOne.getColor());
        System.out.println("ЧТО МОЖЕТ " + wolfOne.getName());
        wolfOne.move();
        wolfOne.seat();
        wolfOne.run();
        wolfOne.howl();
        wolfOne.hunt();
    }
}