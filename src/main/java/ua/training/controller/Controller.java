package ua.training.controller;

import ua.training.model.entity.AdditionalIngredient;
import ua.training.model.entity.Ingredient;
import ua.training.model.entity.Salad;
import ua.training.model.entity.Vegetable;
import ua.training.view.StringsContainer;
import ua.training.view.View;

import java.util.Arrays;

public class Controller {
    private Salad salad;
    private View view;

    public Controller(Salad salad, View view) {
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

}
