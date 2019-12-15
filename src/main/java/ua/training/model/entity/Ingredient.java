package ua.training.model.entity;

public interface Ingredient {
    String name();
    long mass();
    long calories();
    long caloriesIn1KG();
    boolean isPrepared();

    void addMore(long mass);
    void prepareForSalad();
}
