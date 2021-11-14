package com.pb.vasilenko.hw7;

public class Tie extends Clothes implements ManClothes{

    public Tie(Size razmer, double stoimost, String cvet) {
        this.razmer = razmer;
        this.stoimost = stoimost;
        this.cvet = cvet;
    }

    @Override
    public void dressMan() {
        System.out.println("Мужской Tie имеет цвет " + getCvet() + " и размер " + getRazmer() +
                ", и стоит " + getStoimost() + " у.е.");
    }
}

