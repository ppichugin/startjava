package com.startjava.lesson_2_3_4.robot;

public class Jaeger {

    private String modelName;
    private String mark;
    private String origin;
    private int rangers;
    private float height;
    private float weight;
    private int strength;
    private int armor;

    // конструктор
    public Jaeger(String modelName, String mark, String origin, int rangers, float height, float weight, int strength, int armor) {
        this.modelName = modelName;
        this.mark = mark;
        this.origin = origin;
        this.rangers = rangers;
        this.height = height;
        this.weight = weight;
        this.strength = strength;
        this.armor = armor;
    }

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

    public String getMark() {
        return mark;
    }

    public String getOrigin() {
        return origin;
    }

    public int getRangers() {
        return rangers;
    }

    public float getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }

    public int getStrength() {
        return strength;
    }

    public int getArmor() {
        return armor;
    }
}