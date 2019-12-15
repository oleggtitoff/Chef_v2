package ua.training.model.entity;

import java.util.ArrayList;
import java.util.List;

public class SaladImpl implements Salad {
    private List<Ingredient> ingredients = new ArrayList<>();
    private long totalCalories;

    @Override
    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    @Override
    public long getTotalCalories() {
        return 0;   //TODO
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return ingredients;
    }

    @Override
    public List<Ingredient> getIngredientsByCaloriesRange() {
        return null;    //TODO
    }

    @Override
    public void sort() {
        //TODO
    }

}
