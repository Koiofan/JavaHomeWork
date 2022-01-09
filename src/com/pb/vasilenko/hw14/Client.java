package com.pb.vasilenko.hw14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        System.out.println("Клиент запущен");
        String addrServIP = "127.0.0.1";
        int addrServPORT = 1234;
        System.out.println("Соединение по IP:PORT " + addrServIP + ":" + addrServPORT);

        Socket serv = new Socket(addrServIP, addrServPORT);
        BufferedReader polDanServ = new BufferedReader(new InputStreamReader(serv.getInputStream()));
        PrintWriter otpravDanServ = new PrintWriter(serv.getOutputStream(), true);
        BufferedReader danVvod = new BufferedReader(new InputStreamReader(System.in));

        String danOtprav = "";
        String danPol = "";

        while ((danOtprav = danVvod.readLine()) != null) {
            otpravDanServ.println(danOtprav);
            danPol = polDanServ.readLine();
            System.out.println(danPol);
            if ("exit".equalsIgnoreCase(danOtprav)) {
                break;
            }
        }
        //Остановка
        otpravDanServ.close();
        polDanServ.close();
        otpravDanServ.close();
        serv.close();
    }
}
