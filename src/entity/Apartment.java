package entity;

import enumeration.Cities;
import enumeration.Services;

import java.util.List;

public class Apartment {
    private int apartmentId;
    private RegisteredUser owner;

    public int getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(int apartmentId) {
        this.apartmentId = apartmentId;
    }

    public RegisteredUser getOwner() {
        return owner;
    }

    public void setOwner(RegisteredUser owner) {
        this.owner = owner;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(Cities city) {
        this.city = city;
    }

    public String getCitys() {
        return citys;
    }

    public void setCitys(String citys) {
        this.citys = citys;
    }

    public String getPlane() {
        return plane;
    }

    public void setPlane(String plane) {
        this.plane = plane;
    }

    public String getIndoor() {
        return indoor;
    }

    public void setIndoor(String indoor) {
        this.indoor = indoor;
    }

    public String getStair() {
        return stair;
    }

    public void setStair(String stair) {
        this.stair = stair;
    }

    public double getTotalDimension() {
        return totalDimension;
    }

    public void setTotalDimension(double totalDimension) {
        this.totalDimension = totalDimension;
    }

    public double getFreeSpace() {
        return freeSpace;
    }

    public void setFreeSpace(double freeSpace) {
        this.freeSpace = freeSpace;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAvgEvaluation() {
        return avgEvaluation;
    }

    public void setAvgEvaluation(double avgEvaluation) {
        this.avgEvaluation = avgEvaluation;
    }

    public List<Services> getServices() {
        return services;
    }

    public void setServices(List<Services> services) {
        this.services = services;
    }

    public List<Service> getService() {
        return service;
    }

    public void setService(List<Service> service) {
        this.service = service;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void setAptRentCost(double aptRentCost) {
        this.aptRentCost = aptRentCost;
    }

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

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
