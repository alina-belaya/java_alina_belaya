package homework;

public class VegCategory {
    static class Marrow extends Vegetable{

        public Marrow(String name, double calories, double weight){
            super(name, calories, weight);
            this.category = "Marrow";
        }

    }

    static class LeafyGreen extends Vegetable{

        public LeafyGreen(String name, double calories, double weight){
            super(name, calories, weight);
            this.category = "Leafy green";
        }

    }

    static class Root extends Vegetable{

        public Root(String name, double calories, double weight){
            super(name, calories, weight);
            this.category = "Root";
        }

    }

    static class Cruciferous extends Vegetable{

        public Cruciferous(String name, double calories, double weight){
            super(name, calories, weight);
            this.category = "Cruciferous";
        }

    }
}
