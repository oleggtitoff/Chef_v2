package ua.training.model.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AdditionalIngredientTest {
    private AdditionalIngredient additionalIngredient;

    @Before
    public void createAdditionalIngredient() {
        additionalIngredient
                = new AdditionalIngredient("Mayonnaise", 80, 6000);
    }

    @Test
    public void testAddMore() {
        additionalIngredient.addMore(150);

        Assert.assertEquals(230, additionalIngredient.getMass());
        Assert.assertEquals(1380000, additionalIngredient.getCalories());
    }

    @Test
    public void testCalculateCaloriesInMass() {
        long caloriesInThisMass
                = additionalIngredient.calculateCaloriesInMass(100, 10);

        Assert.assertEquals(1000, caloriesInThisMass);
    }

    @Test
    public void testCheckIfIsOpen() {
        boolean isClean = additionalIngredient.getIsOpen();

        Assert.assertFalse(isClean);
    }

    @Test
    public void testPrepareForSalad() {
        additionalIngredient.prepareForSalad();
        boolean isClean = additionalIngredient.getIsOpen();

        Assert.assertTrue(isClean);
    }

}