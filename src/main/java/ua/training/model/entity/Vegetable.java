package ua.training.model.entity;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Vegetable extends IngredientImpl implements Ingredient {
    boolean isClean;

    public Vegetable(String name, long mass, long caloriesIn1KG, long calories) {
        super(name, mass, caloriesIn1KG, calories);
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
