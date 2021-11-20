package com.pb.vasilenko.hw8;

public class WrongPasswordException extends Exception{

    //Конструкторы
    public WrongPasswordException(String soobshen){
        super(soobshen);
    }

    //Конструкторы
    public WrongPasswordException(){

    }

}
