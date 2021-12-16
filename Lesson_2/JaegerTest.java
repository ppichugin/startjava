public class JaegerTest {

    public static void main(String[] args) {
        // синтаксис конструктора: Jaeger(String modelName, String mark, String origin, int rangers, float height, float weight, int strength, int armor)
        Jaeger jaegerOne = new Jaeger("Crimson Typhoon", "Mark-4", "China", 3, 76.2f, 1.722f, 8, 6);
        Jaeger jaegerTwo = new Jaeger("Gipsy Danger", "Mark-3", "USA", 2, 79.25f, 1.980f, 8, 6);
        System.out.println("We have two Jaegers:");
        System.out.println("Model name:" + "\t" + jaegerOne.getModelName() + "\t\t" + jaegerTwo.getModelName());
        System.out.println("Mark version:" + "\t" + jaegerOne.getMark() + "\t\t\t" + jaegerTwo.getMark());
        System.out.println("Origin:" + "\t\t" + jaegerOne.getOrigin() + "\t\t\t" + jaegerTwo.getOrigin());
        System.out.println("Rangers:" + "\t" + jaegerOne.getRangers() + "\t\t\t" + jaegerTwo.getRangers());
        System.out.println("Height:" + "\t\t" + jaegerOne.getHeight() + "\t\t\t" + jaegerTwo.getHeight());
        System.out.println("Weight:" + "\t\t" + jaegerOne.getWeight() + "\t\t\t" + jaegerTwo.getWeight());
        System.out.println("Strength:" + "\t" + jaegerOne.getStrength() + "\t\t\t" + jaegerTwo.getStrength());
        System.out.println("Armor:" + "\t\t" + jaegerOne.getArmor() + "\t\t\t" + jaegerTwo.getArmor());
        System.out.println("\n" + "What they can do:");
        System.out.println("drift:" + "\t\t" + jaegerOne.drift() + "\t\t\t" + jaegerTwo.drift());
        System.out.println("move:" + "\t\t" + jaegerOne.move() + "\t\t" + jaegerTwo.move());
        System.out.println("scan KaiJu:" + "\t" + jaegerOne.scanKaiju() + "\t\t" + jaegerTwo.scanKaiju());
    }
}