package ua.training.model.entity;

import org.junit.Before;

public class AdditionalIngredientTest {
    private AdditionalIngredient additionalIngredient;

    @Before
    public void createAdditionalIngredient() {
        additionalIngredient
                = new AdditionalIngredient("Mayonnaise", 80, 6000);
    }



}