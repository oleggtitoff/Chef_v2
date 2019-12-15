package ua.training.model.entity;

public abstract class IngredientImpl implements Ingredient {
    private String name;
    private long mass;
    private long caloriesIn1G;
    private long calories;

    IngredientImpl(String name, long mass, long caloriesIn1G) {
        this.name = name;
        this.mass = mass;
        this.caloriesIn1G = caloriesIn1G;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public long mass() {
        return mass;
    }

    @Override
    public long calories() {
        return calories;
    }

    @Override
    public long caloriesIn1G() {
        return caloriesIn1G;
    }

    @Override
    public void addMore(long mass) {
        this.mass += mass;
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

    public long getCalories() {
        return calories;
    }

}
