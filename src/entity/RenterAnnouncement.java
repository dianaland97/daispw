package entity;

import enumeration.Cities;

public class RenterAnnouncement extends Announcement{
    private Apartment apt;

    public RenterAnnouncement(Apartment apt, String ownernick, String creationDate){
        super(ownernick, creationDate);
        this.apt = apt;
    }

    @Override
    public String myType() {
        return "renter";
    }

    public void printValues(){
        System.out.println(this.owner + " " + this. creationDate + " " + apt.printValues());
    }

    public Apartment getApartment() {
        return apt;
    }
}
