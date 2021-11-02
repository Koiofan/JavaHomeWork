package com.pb.vasilenko.hw4;

import java.util.Scanner;


public class Anagram {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        String vivodStr = "=================Спасибо!======================" + "\n" +
                "=========Данные строки - это ";

        System.out.println("**********************************");
        System.out.println("Правила анаграммы: ");
        System.out.println("1. Разная последовательность букв.");
        System.out.println("2. Одинаковое количество повторений букв.");
        System.out.println("**********************************");

        System.out.println("==========Введите строку 1=======");
        char[] masChar1 = scan.nextLine().replaceAll("[^a-zA-za-яА-Я]", "").toLowerCase().toCharArray();

        System.out.println("==========Введите строку 2=======");
        char[] masChar2 = scan.nextLine().replaceAll("[^a-zA-za-яА-Я]", "").toLowerCase().toCharArray();

        if(!provAnagram(masChar1, masChar2)){
            vivodStr += "не ";
        }

        System.out.println(vivodStr + "анаграмма=========");
        System.out.println(" ");
    }

    static boolean provAnagram(char[] mas1, char[] mas2){

        //Проверка длинны и одинаковости
        if(mas1.length != mas2.length || String.valueOf(mas1).equals(String.valueOf(mas2)))
        {
            return false;
        }

        char[] simvolMas1 = new char[mas1.length];
        char[] simvolMas2 = new char[mas2.length];;

        int[] qSimvolMas1 = new int[mas1.length];
        int[] qSimvolMas2 = new int[mas2.length];;


        //Подсчет количества повторений
        int ind1 = 0;
        int ind2 = 0;
        for(int i = 0; i < mas1.length; i++) {

            int indSimvol = poiskSimvolMas(simvolMas1, mas1[i]);
            if (indSimvol != -1) {
                qSimvolMas1[indSimvol]++;
            } else {
                simvolMas1[ind1] = mas1[i];
                qSimvolMas1[ind1]++;
                ind1++;
            }

            int indSimvol2 = poiskSimvolMas(simvolMas2, mas2[i]);
            if (indSimvol2 != -1) {
                qSimvolMas2[indSimvol2]++;
            } else {
                simvolMas2[ind2] = mas2[i];
                qSimvolMas2[ind2]++;
                ind2++;
            }
        }

        return provSimvolMas(simvolMas1, simvolMas2, qSimvolMas1, qSimvolMas2);
    }

    static int poiskSimvolMas(char[] mas, char simvol){

        for(int i = 0; i < mas.length; i++){

            if(mas[i] == simvol){
                return i;
            }
        }

        return -1;

    }

    static boolean provSimvolMas(char[] mas1, char[] mas2, int[] qSimvol1, int[] qSimvol2){

        for(int i = 0; i < mas1.length; i++){

            for (int y = 0; y < mas2.length; y++){

                if(mas1[i] == mas2[y]){

                    if(qSimvol1[i] != qSimvol2[y]){

                        return false;
                    }
                    break;
                }
            }

        }

        return true;
    }

}

//Из лекции
/*
//*******************************

public class Person{
    private final String name;

    public Person (String name){
        this.name = name;
    }

    public String пуеТфьу(){
        return name;
    }
}


public class Phone {

    private String number;
    public String model;
    public Float weight;
    private int indicator;

    //Конструктор
    public Phone(String number, String model, float weight) {

        this(number, model);  //Вызов кнструткора из другого конструктора

        this.weight = weight;
        if (weight > 0) {
            this.weight = weight;
        }

    }

    //Конструктор
    public Phone(String number, String model) {
        this.number = number;
        this.model = model;

    }

    //Конструктор
    public Phone() {
        this.number = "0";
        this.model = "x";

    }

    String getInfo() {
        return "[модель: " + model + ", номер: " + number + "]";
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    private boolean isCharger() {
        return indicator > 0;
    }

    public void reciveCall(String Number) {
        System.out.println("Звонит" + Number);
    }

    public void reciveCall(String Number, String  number) {
        if(isCharger()){
            System.out.println("Звонит" + Number + "Номер" + number);
            indicator -= 20;
        }
        else {
            System.out.println("Телефон разраядился");
        }

    }


    public Void sendMassage(String... numbers){
        System.out.println("Сообщениея отпавляются на номера:");

        for(String number: numbers){
            System.out.println(numbers);
        }
        System.out.println("ОТправлено");

    }

    public void charging(){
        System.out.println("Телефон" + model + "Заряжается");
        this.indicator = 100;
        System.out.println("Заряжен");
    }

    public void takePhoto (Person person){
        if(isCharger()){
            System.out.println();
        }
    }

}
//*******************************
//*******************************

        Phone phone1 = new Phone("0","0", 2.f);
        Phone phone2 = new Phone("0","0");
        Phone phone3 = new Phone();

        phone1.model = "iphone";
        phone2.model = "pixel";

        System.out.println(phone1.getInfo());
        System.out.println(phone2.getInfo());
        System.out.println(phone3.getInfo());

        if(phone1.getNumber() != null){

        }

        phone1.charging();

        phone1.reciveCall("Иванов");

        phone1.sendMassage("1234", "asdf");

        phone1.takePhoto(new Person("Петров ф. И."));

//*******************************


 */
