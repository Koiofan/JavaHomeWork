package com.pb.vasilenko.hw5;

import sun.management.VMOptionCompositeData;

import java.security.PublicKey;
import java.util.Arrays;

public class Book {

    private String knigaIma;
    private String knigaAvtor;
    private String knigaGod;


    //Конструктор
    public Book(String knigaIma, String knigaAvtor, String knigaGod){
        setKnigaIma(knigaIma);
        setKnigaAvtor(knigaAvtor);
        setKnigaGod(knigaGod);
    }

    //Установка
    public void setKnigaIma(String knigaIma){
        this.knigaIma = knigaIma;
    }

    public void setKnigaAvtor(String knigaAvtor){
        this.knigaAvtor = knigaAvtor;
    }

    public void setKnigaGod(String knigaGod){
        this.knigaGod = knigaGod;
    }

    //Получение
    public String getKnigaIma(){
        return this.knigaIma;
    }

    public String getKnigaAvtor(){
        return this.knigaAvtor;
    }

    public String getKnigaGod(){
        return this.knigaGod;
    }

}

//Лекция 6
/*
    //**************************************

    Public class Computer {


    }


    Public class Notebook extends Computer{
        private int batterLevel;

      //Конструктор
      public Notebook(){
          super();  //Вызов конструтора родительского класса
      }


    @Override
    public  void on(){
        super.on();
    }

    }

    public static void main(String[] args) {
        Computer comp = new Computer();
        comp.on();

        Notebook note = new Notebook();
        note.on();

        //Computer c1 = new Notebook();

        Computer[] comps = new Computer[] {comp, note};

        for(Computer c: comps){
            c.on();
            use(c);
        }
    }


    public static void use(Computer computer){
        computer.on();
        if(computer instanceof Notebook){
            Notebook note = (Notebook)computer;
        }
    }



    //**************************************

//==================================

    public  class Car{

        private String model;
        public int maxSpeed;


        @Override
        public boolean equals(Object obj){
           return true;
        }

        @Override
        public int  hashCode(){

        }
    }


    public class CarTest{

        public static void main(String[] args) {
            Car car1 = new Car("bmw", 260);
            Car car2 = new Car("kia", 230);
            Car car3 = new Car("bmw", 260);

            System.out.println(car1.equals((car3)));


            System.out.println(car1.hashCode(()));

            System.out.println(car1.toString());
        }
    }


 //================================

//-------------------------------------------

public enum GameLevel{
        EASY("easy"),
        MEDIUM,
        HARD;

    private String name;
    GameLevel(String name){
        this.name = name;
    }
}


public class Game{
    private GameLevel gameLevel;



}

    public class Start{
        Game game = new Game(GameLevel.EASY);
        game.stert();
        GameLevel[] leveks = GameLevel.values();

        GameLevel level = get.GamLevel();
        switch(level){
            case EASY;
        }


    }

 //----------------------------------------------

 //*******************************************
 //Рефлексия
 public class Main{
        public static void main(String[] args) trows Exeption{
            Nootbook nb = new Notebook();
            Class clazz = nb.getClass();
            System.out.println(clazz.getName());
            System.out.println(Arrays.toString(clazz.getMethod()));

            Class compClass = Class.forName("com.pb.vasilenko.hw5.Computer");


            Constuctor constr = compClass.getConstructor(new Class[] {})
            Object obj = constr.newInstance("Asus");


            if(obj instanceof Computer){
                ((Computer) obj).on();
            }


        }
 }

 //********************************************

 */