package homework;

import java.util.ArrayList;
import java.util.List;

public class HW7 {
    public static void main(String[] args) {
        List<House> houses = new ArrayList<>();
        houses.add(new House(213456338, 314, 60.89, 8, 3, "Silver Canoe Way", "Apartments", 20));
        houses.add(new House(908765001, 618, 23.50, 6, 5, "Loch Ness Road", "Dormitory", 50));
        houses.add(new House(688901023, 31, 35.04, 5, 3, "Mistletoe Lane", "Villa", 20));
        houses.add(new House(334591011, 277, 123.0, 21, 7, "Park Avenue", "Skyscraper", 100));
        houses.add(new House(764445322, 10, 41.36, 1, 3, "Twice Avenue", "Semi-detached", 70));
        houses.add(new House(767276519, 1610, 50.0, 16, 4, "Loganberry Lane", "Hotel", 200));
        houses.add(new House(345678700, 111, 39.90, 15, 3, "Super Junior Road", "Apartments", 50));

        System.out.println("a)");
        for (House house: houses) {
            if(house.getRooms() == 3)
                System.out.println(house);
        }

        System.out.println("b)");
        for (House house: houses) {
            if(house.getRooms() == 3 && (house.getFloor() >= 5 && house.getFloor() <= 10))
                System.out.println(house);
        }

        System.out.println("c)");
        for (House house: houses) {
            if(house.getArea() > 50)
                System.out.println(house);
        }
    }
}
