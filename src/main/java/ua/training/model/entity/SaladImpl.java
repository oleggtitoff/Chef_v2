package ua.training.model.entity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<Ingredient> ingredientsByCaloriesRange(long minValue,
                                                       long maxValue) {
        return ingredients.stream()
                .filter(ingredient -> ingredient.caloriesIn1G() >= minValue
                        && ingredient.caloriesIn1G() <= maxValue)
                .collect(Collectors.toList());
    }

    @Override
    public void sort() {
        ingredients = ingredients.stream()
                .sorted(Comparator.comparingLong(Ingredient::caloriesIn1G))
                .collect(Collectors.toList());
    }

    public long getTotalCalories() {
        return totalCalories;
    }

    @Override
    public String toString() {
        return "SaladImpl{" +
                "ingredients=\n" + allIngredientsToString() +
                "totalCalories=" + totalCalories +
                '}';
    }

    private String allIngredientsToString() {
        StringBuilder allIngredients = new StringBuilder();

        ingredients.forEach(ingredient -> {
            allIngredients.append(ingredient.toString());
            allIngredients.append(",\n");
        });
        return allIngredients.toString();
    }

}
