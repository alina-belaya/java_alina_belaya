package homework;

import java.util.Objects;

public class Vegetable implements Comparable <Vegetable> {
    private String name;
    public String category;
    private double calories;
    private double weight;

    public Vegetable(){}

    public Vegetable(String name, double calories, double weight) {
        this.name = name;
        this.calories = calories;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getCalories() {
        return calories * weight / 100;
    }

    public double getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Vegetable o) {
        return this.getCategory().compareTo(o.getCategory());
    }

    @Override
    public String toString() {
        return getName() + " (" + getCategory() + "), " + getWeight() + " grams, " + getCalories() + " calories\n";
    }
}
