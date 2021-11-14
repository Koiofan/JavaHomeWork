package com.pb.vasilenko.hw7;

public class Tshirt extends Clothes implements ManClothes, WomenClothes {

    public Tshirt(Size razmer, double stoimost, String cvet) {
        this.razmer = razmer;
        this.stoimost = stoimost;
        this.cvet = cvet;
    }

    @Override
    public void dressMan() {
        System.out.println("Мужская Tshirt имеет цвет " + getCvet() + " и размер " + getRazmer() +
                ", и стоит " + getStoimost() + " у.е.");
    }

    @Override
    public void dressWomen() {
        System.out.println("Женская Tshirt имеет цвет " + getCvet() + " и размер " + getRazmer() +
                ", и стоит " + getStoimost() + " у.е.");
    }
}
