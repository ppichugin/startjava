public class JaegerTest {

    public static void main(String[] args) {
        Jaeger jaegerOne = new Jaeger();
        Jaeger jaegerTwo = new Jaeger();
        jaegerOne.setModelName("Crimson Typhoon");
        jaegerOne.setMark("Mark-4");
        jaegerOne.setOrigin("China");
        jaegerOne.setRangers(3);
        jaegerOne.setHeight(76.2f);
        jaegerOne.setWeight(1.722f);
        jaegerOne.setStrength(8);
        jaegerOne.setArmor(6);
        jaegerTwo.setModelName("Gipsy Danger");
        jaegerTwo.setMark("Mark-3");
        jaegerTwo.setOrigin("USA");
        jaegerTwo.setRangers(2);
        jaegerTwo.setHeight(79.25f);
        jaegerTwo.setWeight(1.980f);
        jaegerTwo.setStrength(8);
        jaegerTwo.setArmor(6);
        System.out.println("We have two Jagers:");
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