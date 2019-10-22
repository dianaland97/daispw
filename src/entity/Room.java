package entity;

public class Room {
    private int id;
    private double dimension;
    private String cathegory;
    private double rentCost;

    public Room(int id, double dimension, String category, double rentcost) {
        this.id = id;
        this.dimension = dimension;
        this.cathegory = category;
        this.rentCost = rentcost;
    }
}
