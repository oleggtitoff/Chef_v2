package ua.training.model.entity;

import java.util.List;

public interface Salad {
    void addIngredient(Ingredient ingredient);
    long totalCalories();
    List<Ingredient> allIngredients();
    List<Ingredient> ingredientsByCaloriesRange(long minValue, long maxValue);
    void sort();
}
