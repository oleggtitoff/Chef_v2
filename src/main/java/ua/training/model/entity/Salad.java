package ua.training.model.entity;

import java.util.List;

public interface Salad {
    void addIngredient(Ingredient ingredient);
    long getTotalCalories();
    List<Ingredient> getAllIngredients();
    List<Ingredient> getIngredientsByCaloriesRange();
    void sort();
}
