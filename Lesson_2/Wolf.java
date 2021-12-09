public class Wolf {

    private boolean male;
    private String name;
    private float weight;
    private int age;
    private String color;

    //объявляем методы
    public void move() {
        System.out.println("идет");
    }

    public void seat() {
        System.out.println("Сидит");
    }

    public void run() {
        System.out.println("Бежит");
    }

    public void howl() {
        System.out.println("Воет");
    }

    public void hunt() {
        System.out.println("Охотится");
    }
    //назначаем сеттеры и геттеры
    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 8) {
            System.out.println("Некорректный возраст!!!");
        } else {
            this.age = age;
        }
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
}