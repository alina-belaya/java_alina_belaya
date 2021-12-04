package homework;

public class HW9_2 {
    public static void main(String[] args) {
        Vegetable[] ingredients = {new VegCategory.LeafyGreen("Spinach", 40, 27),
                new VegCategory.Marrow("Cucumber", 45, 151),
                new VegCategory.Root("Potato", 77, 213),
                new VegCategory.LeafyGreen("Parsley", 36, 2),
                new VegCategory.Cruciferous("Broccoli", 35, 76)};

        Salad salad = new Salad(ingredients);
        System.out.println("Salad calories: " + salad.countCalories());
        salad.sort();
        System.out.println("Sorted: ");
        System.out.println(salad);
        System.out.println("Calories in range: ");
        salad.getByCalories(20, 100);
    }
}
