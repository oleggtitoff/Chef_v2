package ua.training.model.entity;

public class Vegetable extends IngredientImpl implements Ingredient {
    private boolean isClean;

    public Vegetable(String name, long mass, long caloriesIn1KG) {
        super(name, mass, caloriesIn1KG);
    }

    @Override
    public boolean isPrepared() {
        return isClean;
    }

    @Override
    public void addMore(long mass) {
        // TODO
    }

    @Override
    public void prepareForSalad() {
        // TODO
    }
}
