package com.example.amarrsfinal;

import java.io.Serializable;

public class Trip implements Serializable {

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getSkis() {
        return skis;
    }

    public void setSkis(int skis) {
        this.skis = skis;
    }

    public int getSnowboards() {
        return snowboards;
    }

    public void setSnowboards(int snowboards) {
        this.snowboards = snowboards;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    private String destination;

    private String description;

    private String mode;

    private String time;

    private int skis;

    private int snowboards;

    private double cost;

    private int img;

    public int getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(int rentalCost) {
        this.rentalCost = rentalCost;
    }

    private int rentalCost;

    public boolean isInternational() {
        return international;
    }

    public void setInternational(boolean international) {
        this.international = international;
    }

    private boolean international;
}
