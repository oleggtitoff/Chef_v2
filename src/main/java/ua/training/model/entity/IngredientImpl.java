package ua.training.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public abstract class IngredientImpl implements Ingredient {
    private String name;
    private long mass;
    private long caloriesIn1KG;
    private long calories;

    @Override
    public String name() {
        return null;
    }

    @Override
    public long mass() {
        return 0;
    }

    @Override
    public long calories() {
        return 0;
    }

    @Override
    public long caloriesIn1KG() {
        return 0;
    }
}
