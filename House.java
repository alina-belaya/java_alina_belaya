package homework;

public class House {
    private int id;
    private int number;
    private double area;
    private int floor;
    private int rooms;
    private String street;
    private String type;
    private int term;

    public House(int id, int number, double area, int floor, int rooms, String street, String type, int term) {
        this.id = id;
        this.number = number;
        this.area = area;
        this.floor = floor;
        this.rooms = rooms;
        this.street = street;
        this.type = type;
        this.term = term;
    }

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public double getArea() {
        return area;
    }

    public int getFloor() {
        return floor;
    }

    public int getRooms() {
        return rooms;
    }

    public String getStreet() {
        return street;
    }

    public String getType(){
        return type;
    }

    public int getTerm(){
        return term;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setTerm(int term){
        this.term = term;
    }

    @Override
    public String toString()
    {
        return "House: ID " + id + ", Num " + number + ", " + street + ", Type " + type + ", Term " + term;
    }
}
