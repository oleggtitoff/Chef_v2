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
        return null;
    }

    @Override
    public long mass() {
        return 0;
    }

    @Override
    public long calories() {
        return 0;
    }

    @Override
    public long caloriesIn1G() {
        return 0;
    }
}
