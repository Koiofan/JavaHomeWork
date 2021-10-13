package com.pb.vasilenko.hw2;

import java.util.Scanner;

public class Interval {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int chislo;
        String interval = "";

        System.out.println("Введите целое число");
        chislo = scan.nextInt();

        if (chislo >= 0 && chislo <= 14) {
            interval = "[0 - 14]";
        } else if (chislo >= 15 && chislo <= 35) {
            interval = "[15 - 35]";
        } else if (chislo >= 36 && chislo <= 50) {
            interval = "[36 - 50] ";
        } else if (chislo >= 51 && chislo <= 100) {
            interval = "[51 - 100]";
        } else {
            interval = "вне известного интервала";
        }
        System.out.println("Интервал: " + interval);
    }
}
