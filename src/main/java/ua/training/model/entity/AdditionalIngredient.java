package ua.training.model.entity;

public class AdditionalIngredient extends IngredientImpl implements Ingredient {
    private boolean isOpen;

    AdditionalIngredient(String name, long mass, long caloriesIn1G) {
        super(name, mass, caloriesIn1G);
    }

    @Override
    public boolean isPrepared() {
        return isOpen;
    }

    @Override
    public void prepareForSalad() {
        isOpen = true;
    }

    public boolean getIsOpen() {
        return isOpen;
    }

}
