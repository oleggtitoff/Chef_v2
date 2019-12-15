package ua.training.model.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SaladImplTest {
    private SaladImpl salad;

    @Before
    public void createSalad() {
        salad = new SaladImpl();
        salad.addIngredient(new Vegetable("Carrot", 250, 3100));
        salad.addIngredient(new Vegetable("Potato", 500, 8000));
        salad.addIngredient(new AdditionalIngredient("Sauce", 100, 5000));
        salad.addIngredient(new AdditionalIngredient("Salt", 5, 0));
    }

    @Test
    public void testAddIngredient() {
        Assert.assertEquals(4, salad.getAllIngredients().size());
    }

}