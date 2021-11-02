package com.pb.vasilenko.hw5;

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
