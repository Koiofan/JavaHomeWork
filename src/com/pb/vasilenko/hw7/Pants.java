package com.pb.vasilenko.hw7;

public class Pants extends Clothes implements ManClothes, WomenClothes{

    public Pants(Size razmer, double stoimost, String cvet) {
        this.razmer = razmer;
        this.stoimost = stoimost;
        this.cvet = cvet;

    }

    @Override
    public void dressMan() {
        System.out.println("Мужские Pants имеет цвет " + getCvet() + " и размер " + getRazmer() +
                ", и стоит " + getStoimost() + " у.е.");
    }

    @Override
    public void dressWomen() {
        System.out.println("Женские Pants имеет цвет " + getCvet() + " и размер " + getRazmer() +
                ", и стоит " + getStoimost() + " у.е.");
    }

}
