package ua.training.model.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VegetableTest {
    private Vegetable vegetable;

    @Before
    public void createVegetable() {
        vegetable = new Vegetable("Potato", 100, 1000);
    }

    @Test
    public void testAddMore() {
        vegetable.addMore(150);

        Assert.assertEquals(250, vegetable.getMass());
        Assert.assertEquals(250000, vegetable.getCalories());
    }

    @Test
    public void testCalculateCaloriesInMass() {
        long caloriesInThisMass = vegetable.calculateCaloriesInMass(100, 10);

        Assert.assertEquals(1000, caloriesInThisMass);
    }

    @Test
    public void testCheckIfIsClean() {
        boolean isClean = vegetable.getIsClean();

        Assert.assertFalse(isClean);
    }

    @Test
    public void testPrepareForSalad() {
        vegetable.prepareForSalad();
        boolean isClean = vegetable.getIsClean();

        Assert.assertTrue(isClean);
    }

}