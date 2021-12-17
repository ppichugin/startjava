public class JaegerTest {

    public static void main(String[] args) {
        // синтаксис конструктора: Jaeger(String modelName, String mark, String origin, int rangers, float height, float weight, int strength, int armor)
        Jaeger jaegerOne = new Jaeger("Crimson Typhoon", "Mark-4", "China", 3, 76.2f, 1.722f, 8, 6);
        Jaeger jaegerTwo = new Jaeger("Gipsy Danger", "Mark-3", "USA", 2, 79.25f, 1.980f, 8, 6);
        System.out.println("We have two Jaegers:");
        System.out.printf("%-20s %-20s %-20s %n", "Model name:", jaegerOne.getModelName(), jaegerTwo.getModelName());
        System.out.printf("%-20s %-20s %-20s %n", "Mark version:", jaegerOne.getMark(), jaegerTwo.getMark());
        System.out.printf("%-20s %-20s %-20s %n", "Origin:", jaegerOne.getOrigin(), jaegerTwo.getOrigin());
        System.out.printf("%-20s %-20d %-20d %n", "Rangers:", jaegerOne.getRangers(), jaegerTwo.getRangers());
        System.out.printf("%-20s %-20.2f %-20.2f %n", "Height:", jaegerOne.getHeight(), jaegerTwo.getHeight());
        System.out.printf("%-20s %-20.3f %-20.3f %n", "Weight:", jaegerOne.getWeight(), jaegerTwo.getWeight());
        System.out.printf("%-20s %-20d %-20d %n", "Strength:", jaegerOne.getStrength(), jaegerTwo.getStrength());
        System.out.printf("%-20s %-20d %-20d %n\n", "Armor:", jaegerOne.getArmor(), jaegerTwo.getArmor());
        System.out.println("What they can do:");
        System.out.printf("%-20s %-20s %-20s %n", "drift:", jaegerOne.drift(), jaegerTwo.drift());
        System.out.printf("%-20s %-20s %-20s %n", "move:", jaegerOne.move(), jaegerTwo.move());
        System.out.printf("%-20s %-20s %-20s %n", "scan KaiJu:", jaegerOne.scanKaiju(), jaegerTwo.scanKaiju());
    }
}