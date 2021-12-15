public class Jaeger {

    private String modelName;
    private String mark;
    private String origin;
    private int rangers;
    private float height;
    private float weight;
    private int strength;
    private int armor;

    public boolean drift() {
        return true;
    }

    public String move() {
        if (mark.equals("Mark-4")) {
            return "fast moving";
        }
        return "slow moving";
    }

    public String scanKaiju() {
        if (mark.equals("Mark-3")) {
            return "deep scanning";
        }
        return "scanning";
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getRangers() {
        return rangers;
    }

    public void setRangers(int rangers) {
        this.rangers = rangers;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }
}