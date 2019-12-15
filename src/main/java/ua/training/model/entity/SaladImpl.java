package ua.training.model.entity;

import java.util.ArrayList;
import java.util.List;

public class SaladImpl implements Salad {
    private List<Ingredient> ingredients = new ArrayList<>();
    private long totalCalories;

    @Override
    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
        addCaloriesToTotal(ingredient);
    }

    private void addCaloriesToTotal(Ingredient ingredient) {
        totalCalories += ingredient.calories();
    }

    @Override
    public long totalCalories() {
        return totalCalories;
    }

    @Override
    public List<Ingredient> allIngredients() {
        return ingredients;
    }

    @Override
    public List<Ingredient> ingredientsByCaloriesRange() {
        return null;    //TODO
    }

    @Override
    public void sort() {
        //TODO
    }

    public long getTotalCalories() {
        return totalCalories;
    }

}
