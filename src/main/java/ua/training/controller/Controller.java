package ua.training.controller;

import ua.training.model.entity.AdditionalIngredient;
import ua.training.model.entity.Ingredient;
import ua.training.model.entity.Salad;
import ua.training.model.entity.Vegetable;
import ua.training.view.StringsContainer;
import ua.training.view.View;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Controller {
    private Salad salad;
    private View view;

    public Controller(Salad salad, View view) {
        Objects.requireNonNull(salad);
        Objects.requireNonNull(view);

        this.salad = salad;
        this.view = view;
    }

    public void processUser() {
        addIngredients();
        view.printMessage(view.getBundleString(StringsContainer.SALAD_WORD));
        view.printMessage(view.getBundleString(StringsContainer.INGREDIENTS_MESSAGE));
        printIngredientsList(salad.allIngredients());

        salad.sort();
        view.printMessage(view.getBundleString(StringsContainer.SORT_MESSAGE));
        view.printMessage(view.getBundleString(StringsContainer.INGREDIENTS_MESSAGE));
        printIngredientsList(salad.allIngredients());

        view.printMessage(view.getBundleString(StringsContainer.RANGE_MESSAGE));
        printIngredientsList(salad.ingredientsByCaloriesRange(1900, 4000));

        view.printMessage(view.concatenationString(
                view.getBundleString(StringsContainer.TOTAL_CALORIES_MESSAGE),
                StringsContainer.SPACE_SIGN,
                String.valueOf(salad.totalCalories())));
    }

    private void addIngredients() {
        Arrays.stream(Input.values())
                .limit(4)
                .forEach(input -> salad.addIngredient(
                        new Vegetable(input.getName(),
                                input.getMass(),
                                input.getCaloriesIn1G())
                ));
        Arrays.stream(Input.values())
                .skip(4)
                .forEach(input -> salad.addIngredient(
                        new AdditionalIngredient(input.getName(),
                                input.getMass(),
                                input.getCaloriesIn1G())
                ));
    }

    private void printIngredientsList(List<Ingredient> ingredients) {
        ingredients.forEach(ingredient -> {
                    if (ingredient instanceof Vegetable) {
                        view.printMessage(getVegetableString(ingredient));
                    } else {
                        view.printMessage(getAdditionalIngredientString(ingredient));
                    }
                });

    }

    private String getVegetableString(Ingredient ingredient) {
        return view.concatenationString(
                view.getBundleString(StringsContainer.VEGETABLE_WORD)
                        + getIngredientString(ingredient));
    }

    private String getAdditionalIngredientString(Ingredient ingredient) {
        return view.concatenationString(
                view.getBundleString(StringsContainer.ADDITIONAL_INGREDIENT_WORD)
                        + getIngredientString(ingredient));
    }

    private String getIngredientString(Ingredient ingredient) {
        return view.concatenationString(
                StringsContainer.OPEN_CURLY_BRACE
                        + view.getBundleString(StringsContainer.NAME_WORD)
                        + StringsContainer.EQUAL_SIGN + ingredient.name()
                        + StringsContainer.COMMA_SIGN + StringsContainer.SPACE_SIGN
                        + view.getBundleString(StringsContainer.MASS_WORD)
                        + StringsContainer.EQUAL_SIGN + ingredient.mass()
                        + StringsContainer.COMMA_SIGN + StringsContainer.SPACE_SIGN
                        + view.getBundleString(StringsContainer.CALORIES_IN_1_G_WORD)
                        + StringsContainer.EQUAL_SIGN + ingredient.caloriesIn1G()
                        + StringsContainer.COMMA_SIGN + StringsContainer.SPACE_SIGN
                        + view.getBundleString(StringsContainer.CALORIES_WORD)
                        + StringsContainer.EQUAL_SIGN + ingredient.calories()
                        + StringsContainer.CLOSE_CURLY_BRACE
        );
    }

}
