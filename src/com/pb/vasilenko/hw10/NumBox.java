package com.pb.vasilenko.hw10;

public class NumBox <T extends Number> {

    private T[] masT;
    private int tekIndMas = 0;

    public NumBox(int masRazmer) {
        masT = (T[]) new Number[masRazmer];
    }

    public void add(T num) throws Exception{

       if(tekIndMas > masT.length-1){
          throw new Exception("Ошибка! Массив уже заполнен!");
       }

       masT[tekIndMas++] = num;
    }

    public T get(int ind) throws Exception{

        if(ind >= tekIndMas){
            throw new Exception("Ошибка! Элемент не существует!");
        }

        return masT[ind];
    }

    public int length(){
        return tekIndMas;
    }

    public double average(){

        double srArifm = 0;

        for (int i = 0; i < tekIndMas; i++){

            srArifm += masT[i].doubleValue();
        }

        return srArifm/tekIndMas;
    }

    public double sum(){
        double sum = 0;

        for (int i = 0; i < tekIndMas; i++){

            sum += masT[i].doubleValue();
        }

        return sum;
    }

    public T max(){
        int ind = 0;
        double maxElem = 0;

        for (int i = 0; i < tekIndMas; i++){

            if(masT[i].doubleValue() > maxElem){
                maxElem = masT[i].doubleValue();
                ind = i;
            }

        }

        return masT[ind];
    }
}
