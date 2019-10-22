package entity;

import enumeration.Cities;
import enumeration.Services;

public class Filters {
    private double minCost, maxcost;
    private Cities city;
    private Services[] service;

    public Filters(double minc, double maxc, Cities ci, Services[] servs){
        this.minCost = minc;
        this.maxcost = maxc;
        this.city = ci;
        this.service = servs;
    }

    public double getMincost() {
        return this.minCost;
    }

    public double getMaxcost() {
        return this.maxcost;
    }

    public Cities getCity() {
        return this.city;
    }

    public Services[] getServices() {
        return this.service;
    }

}
