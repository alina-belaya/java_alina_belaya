package homework;

import java.util.ArrayList;
import java.util.Arrays;

public class Salad{
    public Vegetable[] salad;

    public Salad(Vegetable[] salad) {
        this.salad = salad;
    }

    public Salad() {

    }

    public void addIngredient(Vegetable vegetable) {
        int n = this.salad.length;
        Vegetable[] copy = Arrays.copyOf(this.salad, n);
        this.salad = new Vegetable[n + 1];
        System.arraycopy(copy, 0, salad,0, n);
        salad[n] = vegetable;
    }

    public double countCalories() {
        double calories = 0.0;

        for (Vegetable vegetable : salad) {
            calories += vegetable.getCalories();
        }

        return calories;
    }

    public void sort() {
        Arrays.sort(this.salad);
    }

    public void getByCalories(int a, int b){
        for (Vegetable ingridient: salad){
            if (ingridient.getCalories() >= a && ingridient.getCalories() <= b)
                System.out.print(ingridient);
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Vegetable ingridient : salad) {
            s.append(ingridient);
        }
        return s.toString();
    }
}
