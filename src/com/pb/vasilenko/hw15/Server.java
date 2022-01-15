package com.pb.vasilenko.hw15;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    static class Handler implements Runnable {
        private final Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {

            BufferedReader polDanServ = null;
            PrintWriter otpravDanServ = null;

            try {
                polDanServ = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                otpravDanServ = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }

            String danOtprav = "";
            String danPol = "";

            System.out.println("Подключился клиент.");

            while (true) {
                try {
                    if (!((danPol = polDanServ.readLine()) != null)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if ("exit".equalsIgnoreCase(danPol)) {
                    break;
                }

                danOtprav = danPol;

                otpravDanServ.println(LocalDateTime.now().toString() + " " + danOtprav);
                System.out.println(danPol);
            }

            otpravDanServ.close();
            try {
                polDanServ.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Сеанс с клиентом завершен.");

        }
    }

    public static void main(String[] args) throws Exception {
        int port = 1234;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Сервер запущен на порту : " + port);
        ExecutorService threadPool = Executors.newFixedThreadPool(5);


        while (true) {
            Socket clientSocket = serverSocket.accept();
            threadPool.submit(new Server.Handler(clientSocket));
        }
    }
}