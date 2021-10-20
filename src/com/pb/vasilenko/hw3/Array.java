package com.pb.vasilenko.hw3;

import java.util.Scanner;

public class Array {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        int[] masChislo = new int[10];

        int sumElementVse = 0;
        int qElementPolozh = 0;

        for (int i = 0; i < masChislo.length; i++) {

            System.out.println("Введите целое число.");
            masChislo[i] = scan.nextInt();

        }

        System.out.println("Вы ввели следующие числа:");

        for (int i = 0; i < masChislo.length; i++) {

            sumElementVse += masChislo[i];
            if(masChislo[i] > 0){
                qElementPolozh++;
            }
            System.out.println(masChislo[i]);

        }

        System.out.println("Сумма введенных чисел: " + sumElementVse + ".");
        System.out.println("Количество положительных чисел: " + qElementPolozh + ".");

        int qProh = 1;

        while(qProh != 0){
            qProh = 0;

            for (int i = 1; i < masChislo.length; i++) {

                int elementPred = masChislo[i-1];

                if(masChislo[i] < elementPred){
                    qProh++;

                    masChislo[i-1] = masChislo[i];
                    masChislo[i] = elementPred;
                }

            }

        }

        System.out.println("Числа после сортировки:");

        for (int i = 0; i < masChislo.length; i++) {

            System.out.println(masChislo[i]);

        }

    }
}
