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
    public void prepareForSalad() {
        isClean = true;
    }

    public boolean getIsClean() {
        return isClean;
    }

    @Override
    public String toString() {
        return "Vegetable{" +
                super.toString() +
                ", isClean=" + isClean +
                '}';
    }

}
