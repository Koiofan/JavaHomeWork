package com.pb.vasilenko.hw7;

public abstract class Clothes {
    Size razmer;
    double stoimost;
    String cvet;


    public void setRazmer(Size razmer) {
        this.razmer = razmer;
    }

    public void setStoimost(double stoimost) {
        this.stoimost = stoimost;
    }

    public void setCvet(String cvet) {
        this.cvet = cvet;
    }

    public Size getRazmer() {
        return razmer;
    }

    public double getStoimost() {
        return stoimost;
    }

    public String getCvet() {
        return cvet;
    }
}
