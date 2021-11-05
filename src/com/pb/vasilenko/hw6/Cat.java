package com.pb.vasilenko.hw6;

import java.util.Objects;

public class Cat extends Animal{

    //Конструктор
    public Cat (String food, String location, String otlichie){
        super(food, location);
        setOtlichie(otlichie);
    }

    //Переменные
    private String otlichie;

    //Установка
    public void setOtlichie(String otlichie){
        this.otlichie = otlichie;
    }

    //Получение
    public String getOtlichie(){
        return this.otlichie;
    }

    //Переопределение
    @Override
    protected void makeNoise(String zhivotn) {
        System.out.println(zhivotn + " очень шумит.");
    }

    @Override
    protected void eat(String zhivotn) {
        System.out.println(zhivotn + " много кушает.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(otlichie, cat.otlichie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(otlichie);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "otlichie='" + otlichie + '\'' +
                '}';
    }
}


