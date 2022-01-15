package com.pb.vasilenko.hw15;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    static Socket serv;
    static BufferedReader polDanServ;
    static PrintWriter otpravDanServ;
    static BufferedReader danVvod;

    public static void main(String[] args) throws IOException {

        StartSet();     //Запуск соединения
        OknoRab();      //Работа с окном
    }

    //Запуск соединения
    private static void StartSet() throws IOException {
        System.out.println("Клиент запущен");
        String addrServIP = "127.0.0.1";
        int addrServPORT = 1234;
        System.out.println("Соединение по IP:PORT " + addrServIP + ":" + addrServPORT);

        serv = new Socket(addrServIP, addrServPORT);
        polDanServ = new BufferedReader(new InputStreamReader(serv.getInputStream()));
        otpravDanServ = new PrintWriter(serv.getOutputStream(), true);
        danVvod = new BufferedReader(new InputStreamReader(System.in));
    }

    //Работа с окном
    private static void OknoRab() {
        Frame oknoKlient = new Frame();
        Label otvetServ = new Label("Ответ от сервера...");
        Button knOtprav = new Button("Отправить");
        TextField poleVvod = new TextField();

        otvetServ.setBounds(20, 30, 300, 30);
        poleVvod.setBounds(20, 60, 80, 30);
        knOtprav.setBounds(100, 60, 80, 30);

        oknoKlient.add(knOtprav);
        oknoKlient.add(otvetServ);
        oknoKlient.add(poleVvod);

        oknoKlient.setSize(300, 120);
        oknoKlient.setTitle("Клиент");

        oknoKlient.setLayout(null);  //Отключение менеджера компоновки по умолчанию

        //Обработка закрытия окна
        oknoKlient.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                oknoKlient.dispose();
            }
        });

        //Обработка нажатия на кнопку
        knOtprav.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

                String danOtprav = poleVvod.getText();
                System.out.println("Отправка: " + danOtprav);

                String danPol = "";

                otpravDanServ.println(danOtprav);    //Отправка данных на сервер
                try {
                    danPol = polDanServ.readLine();  //Получение данных от сервера
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(danPol);      //Вывод ответа сревера в консоль
                otvetServ.setText(danPol);       //Вывод ответа сревера в окно

                //Проверка на команду выхода
                if ("exit".equalsIgnoreCase(danOtprav)) {
                    try {
                        StopSet();              //Остановка соединения
                        oknoKlient.dispose();   //Закрытие окна
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        oknoKlient.setVisible(true);
    }

    //Остановка соединения
    private static void StopSet() throws IOException {
        //Остановка
        otpravDanServ.close();
        polDanServ.close();
        otpravDanServ.close();
        serv.close();
    }


}
