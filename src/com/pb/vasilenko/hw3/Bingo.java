package com.pb.vasilenko.hw3;

import java.util.Random;
import java.util.Scanner;

public class Bingo {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        System.out.println("==========Начало игры!=============");

        String alternatRezultat = "";
        String chisloStr = "";
        int chisloZ = random.nextInt(101);
        int chisloIgrok;
        int qPopitok = 0;  //Почему требует инициализацию 0, ведь должно инициализироваться 0 по умолчанию?

        System.out.println("Было загадано целое число. Попробуйте отгадать это число.");

        while(true){
            qPopitok++;   //Здесь ошибка если объявить без инициализации так: "int qPopitok;"

            System.out.println("Введите целое число от 0 до 100 или 'q' для заврешения игры.");
            chisloStr = scan.next();

            if(chisloStr.equals("q") || chisloStr.equals("й")){
                alternatRezultat = ", но число так и не отгадано";
                break;
            }

            chisloIgrok = Integer.parseInt(chisloStr);

            if(chisloIgrok < 0 || chisloIgrok > 100){
                System.out.println("Некорректный ввод. Число вне интервала [0-100]. Попробуете снова.");
                continue;
            }

            if(chisloIgrok == chisloZ){
                System.out.println("Число отгадано правильно! Использовано попыток: " + qPopitok);
                break;
            }

            if(chisloIgrok > chisloZ){
                System.out.println("Введенное число больше загаданного. Попробуете снова.");
            }
            else{
                System.out.println("Введенное число меньше загаданного. Попробуете снова.");
            }
        }

        System.out.println("==========Игра завершена" + alternatRezultat + "!==========");

    }
}
