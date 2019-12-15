package ua.training.model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SaladImpl implements Salad {
    private List<Ingredient> ingredients = new ArrayList<>();
    private long totalCalories;

    @Override
    public void addIngredient(Ingredient ingredient) {
        Optional<Ingredient> optionalIngredient = findIngredientInSalad(ingredient);

        if (optionalIngredient.isPresent()) {
            optionalIngredient.get().addMore(ingredient.mass());
        } else {
            ingredients.add(ingredient);
        }
        addCaloriesToTotal(ingredient);
    }

    private Optional<Ingredient> findIngredientInSalad(Ingredient newIngredient) {
        return ingredients.stream()
                .filter(ingredient -> ingredient.name().equals(newIngredient.name()))
                .findAny();
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
