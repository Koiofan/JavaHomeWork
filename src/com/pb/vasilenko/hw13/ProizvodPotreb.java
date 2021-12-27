package com.pb.vasilenko.hw13;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Класс произмводитель потребитель
public class ProizvodPotreb {   //Класс произмводитель потребитель

    //Главный код
    public static void main(String[] args) {  //Главный код

        Object lockPP = new Object();
        List<Integer> buferPP = new ArrayList<Integer>();

        Thread proizvodPotok = new Thread(new Proizvod(lockPP, buferPP));
        Thread potrebPotok = new Thread(new Potreb(lockPP, buferPP));

        proizvodPotok.start();
        potrebPotok.start();

    }  //Главный код

    //Класс производитель
    static class Proizvod implements Runnable {  //Класс производитель

        private final Object lockPP;
        private final List<Integer> buferPP;

        public Proizvod(Object lockPP, List<Integer> buferPP) {
            this.lockPP = lockPP;
            this.buferPP = buferPP;
        }

        public void run() {

            while (true){
                synchronized (lockPP) {
                    try {
                        if(buferPP.size() < 5 ){
                            System.out.println("Произвел");
                            int sluchCisl = new Random().nextInt(10);
                            buferPP.add(sluchCisl);
                        }
                        else{
                            lockPP.notify();
                            lockPP.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }  //Класс производитель
    }

    //Класс потребитель
    static class Potreb implements Runnable {  //Класс потребитель

        private final Object lockPP;
        private final List<Integer> buferPP;

        public Potreb(Object lockPP, List<Integer> buferPP) {
            this.lockPP = lockPP;
            this.buferPP = buferPP;
        }

        public void run() {
            while (true) {
                synchronized (lockPP) {
                    try {

                        if (buferPP.size() > 0) {
                            System.out.println("Потребил");
                            System.out.println(buferPP.get(0));
                            buferPP.remove(0);
                        } else {
                            lockPP.notify();
                            lockPP.wait();
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }  //Класс потребитель

    }  //Класс произмводитель потребитель
}  //Класс произмводитель потребитель
