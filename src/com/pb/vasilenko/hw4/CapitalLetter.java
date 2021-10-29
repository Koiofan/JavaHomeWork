package com.pb.vasilenko.hw4;

import java.util.Scanner;

public class CapitalLetter {
    public static void main(String[] args){
        String vivodStr = "";

        Scanner scan = new Scanner(System.in);

        System.out.println("==========Введите строку=======");
        String[] masStr = scan.nextLine().split(" ");
        System.out.println("=====Форматированная строка=====");

        for(String Str : masStr){

            vivodStr += formatVerhReg(Str) + " ";

        }

        System.out.println(vivodStr);

        System.out.println("===========Спасибо!===========");
    }

    static String formatVerhReg(String Str){

        char[] masSimv = Str.toCharArray();
        masSimv[0] = Character.toUpperCase(masSimv[0]);
        return  new String(masSimv);

    }

}
