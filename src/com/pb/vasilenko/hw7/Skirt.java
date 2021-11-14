package com.pb.vasilenko.hw7;

public class Skirt extends Clothes implements WomenClothes{

    public Skirt(Size razmer, double stoimost, String cvet) {
        this.razmer = razmer;
        this.stoimost = stoimost;
        this.cvet = cvet;

    }

    @Override
    public void dressWomen() {
        System.out.println("Женская Skirt имеет цвет " + getCvet() + " и размер " + getRazmer() +
                ", и стоит " + getStoimost() + " у.е.");
    }
}
