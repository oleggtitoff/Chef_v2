package ua.training.controller;

import ua.training.model.entity.AdditionalIngredient;
import ua.training.model.entity.Ingredient;
import ua.training.model.entity.Salad;
import ua.training.model.entity.Vegetable;
import ua.training.view.StringsContainer;
import ua.training.view.View;

import java.util.Arrays;
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

        view.printMessage("Before sort: " + salad.toString());
        salad.sort();
        view.printMessage("After sort: " + salad.toString());

        view.printMessage("In range [1900-4000]: "
                + salad.ingredientsByCaloriesRange(1900, 4000));


        view.printMessage("Total calories: " + salad.totalCalories());
        view.printMessage("All ingredients: " + salad.allIngredients());
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
        );
    }

}
