package entity;

import enumeration.Cities;
import enumeration.Services;

import java.util.List;

public class Apartment {
    private int apartmentId;
    private RegisteredUser owner;
    private String address;
    private String cap;
    private Cities city;
    String citys;
    private String plane;
    private String indoor;
    private String stair;
    private double totalDimension;
    private double freeSpace;
    private int numberOfRooms;
    private String state;
    private String title;
    private String description;
    private double avgEvaluation;
    private List<String> imagespath;
    private List<Services> services;
    private List<Service> service;
    private List<Room> rooms;
    private double aptRentCost;

    public Apartment(int aptid, Cities city, double avgEvaluation, RegisteredUser owner, String address, String cap, String plane, String indoor,
                     String stair, List<String> imgpath, List<Services> services, String title, List<Room> rooms, String description,
                     double totalDimension, double freeSpace, int numberOfRooms, String state, double aptRentCost){
        this.apartmentId = aptid;
        this.city = city;
        this.avgEvaluation = avgEvaluation;
        this.owner = owner;
        this.imagespath = imgpath;
        this.services = services;
        this.title = title;
        this.description = description;
        this.aptRentCost = aptRentCost;
        this.rooms = rooms;
        this.address = address;
        this.cap = cap;
        this. plane = plane;
        this.indoor = indoor;
        this.stair = stair;
        this.totalDimension = totalDimension;
        this.freeSpace = freeSpace;
        this.numberOfRooms = numberOfRooms;
        this.state = state;
    }

    public Apartment(int aptid, String city, double avgEvaluation, RegisteredUser owner, String address, String cap, String plane, String indoor,
                     String stair, List<String> imgpath, List<Service> services, String title, List<Room> rooms, String description,
                     double totalDimension, double freeSpace, int numberOfRooms, String state, double aptRentCost){
        this.apartmentId = aptid;
        this.citys = city;
        this.avgEvaluation = avgEvaluation;
        this.owner = owner;
        this.imagespath = imgpath;
        this.service = services;
        this.title = title;
        this.description = description;
        this.aptRentCost = aptRentCost;
        this.rooms = rooms;
        this.address = address;
        this.cap = cap;
        this. plane = plane;
        this.indoor = indoor;
        this.stair = stair;
        this.totalDimension = totalDimension;
        this.freeSpace = freeSpace;
        this.numberOfRooms = numberOfRooms;
        this.state = state;
    }

    public List<Services> getApartmentServices(){
        return this.services;
    }

    public String printValues() {
        return city.name() + " "  + avgEvaluation + " "  + owner.whoIam() + " "  + title + " "  + description;
    }

    public Cities getLocation() {
        return city;
    }

    public double myAvgEvaluation() {
        return this.avgEvaluation;
    }

    public String myName() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public double getAptRentCost() {
        return this.aptRentCost;
    }

    public int getId() {
        return this.apartmentId;
    }

    public List<String> getImagespath() {
        return imagespath;
    }

    public void setImagespath(List<String> imagespath) {
        this.imagespath = imagespath;
    }
}
