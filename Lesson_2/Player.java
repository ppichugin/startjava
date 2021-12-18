public class Player {

    private String name;
    private int minRange = 1;
    private int maxRange = 100;

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

    public int Corrections() {
        return ((this.minRange + this.maxRange) / 2);
    }
}