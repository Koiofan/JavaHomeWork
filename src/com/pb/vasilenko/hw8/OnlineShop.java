package com.pb.vasilenko.hw8;

import java.util.Scanner;

public class OnlineShop {
    public static void main(String[] args) throws WrongLoginException, WrongPasswordException {

        Scanner scan = new Scanner(System.in);

        String login = "";
        String password = "";
        String confirmPassword = "";

        Auth klient = new Auth();

        System.out.println("Зарегистрируйтесь!");
        while (true) {
            System.out.println("Придумайте логин");
            login = scan.next();
            System.out.println("Придумайте пароль");
            password = scan.next();
            System.out.println("Повторите пароль");
            confirmPassword = scan.next();

            try {
                klient.signUp(login, password, confirmPassword);
                klient.setLogin(login);
                klient.setPassword(password);
                break;
            } catch (WrongLoginException Ex) {
                System.out.println(Ex);
            } catch (WrongPasswordException Ex) {
                System.out.println(Ex);
            }

            System.out.println("Попробуйте снова!");

        }

        System.out.println("Войдите на сайт!");
        while (true) {

            System.out.println("Введите логин");
            login = scan.next();
            System.out.println("Введите пароль");
            password = scan.next();

            try {
                klient.signIn(login, password);
                break;
            } catch (WrongLoginException Ex) {
                System.out.println(Ex);
            }
            System.out.println("Попробуйте снова!");
        }

    }
}