package com.pb.vasilenko.hw2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int operand1;
        int operand2;
        String sign = "";

        System.out.println("Введите первое число");
        operand1 = scan.nextInt();
        System.out.println("Введите второе число");
        operand2 = scan.nextInt();
        System.out.println("Введите знак арифметической операции");
        sign = scan.next();

        switch (sign) {
            case "+":
                operand1 += operand2;
                break;
            case "-":
                operand1 -= operand2;
                break;
            case "*":
                operand1 *= operand2;
                break;
            case "/":
                if (operand2 != 0) {
                    operand1 /= operand2;
                } else {
                    System.out.println("Ошибка. Деление на 0 невозможно!");
                    return;
                }
                break;
        }

        System.out.println(operand1);
    }

}
