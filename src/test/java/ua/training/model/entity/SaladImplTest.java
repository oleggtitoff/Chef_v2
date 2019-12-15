package ua.training.model.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

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
        Assert.assertEquals(4, salad.allIngredients().size());
    }

    @Test
    public void testAddExistingIngredient() {
        salad.addIngredient(new Vegetable("Carrot", 100, 3100));

        Assert.assertEquals(4, salad.allIngredients().size());
        Assert.assertEquals(350, salad.allIngredients().get(0).mass());
    }

    @Test
    public void testGetTotalKCalories() {
        long totalKCalories = salad.getTotalCalories();

        Assert.assertEquals(5275000, totalKCalories);
    }

    @Test
    public void testGetIngredientsByCaloriesRange() {
        List<Ingredient> ingredients = salad.ingredientsByCaloriesRange(4000, 8000);

        Assert.assertEquals(2, ingredients.size());
        Assert.assertEquals(8000, ingredients.get(0).caloriesIn1G());
        Assert.assertEquals(5000, ingredients.get(1).caloriesIn1G());
    }

    @Test
    public void testSort() {
        salad.sort();

        Assert.assertEquals("Salt", salad.allIngredients().get(0).name());
        Assert.assertEquals("Carrot", salad.allIngredients().get(1).name());
        Assert.assertEquals("Sauce", salad.allIngredients().get(2).name());
        Assert.assertEquals("Potato", salad.allIngredients().get(3).name());
    }

}