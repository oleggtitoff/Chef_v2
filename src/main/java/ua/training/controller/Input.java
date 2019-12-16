package ua.training.controller;

public enum Input {
    POTATO("Potato", 300, 8000),
    CARROT("Carrot", 200, 3100),
    TOMATO("Tomato", 250, 1900),
    ONION("Onion", 100, 3000),
    MAYONNAISE("Mayonnaise", 80, 60000),
    SALT("Salt", 5, 0);

    private final String name;
    private final long mass;
    private final long caloriesIn1G;

    Input(String name, long mass, long caloriesIn1G) {
        this.name = name;
        this.mass = mass;
        this.caloriesIn1G = caloriesIn1G;
    }

    public String getName() {
        return name;
    }

    public long getMass() {
        return mass;
    }

    public long getCaloriesIn1G() {
        return caloriesIn1G;
    }

}
