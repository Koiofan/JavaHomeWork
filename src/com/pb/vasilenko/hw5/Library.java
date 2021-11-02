package com.pb.vasilenko.hw5;

public class Library {  //Главный класс
    public static void main(String[] args) {  //Главный код

        Book[] masKnig = {
                new Book("Приключения", "Иванов И. И.", "2000 г."),
                new Book("Словарь", "Сидоров А. В.", "1980 г."),
                new Book("Энциклопедия", "Гусев К. В.", "2010 г.")
        };       //Массив книг

        Reader[] masChit = {
                new Reader("Петров В.В",1,"А","01.01.1990", "111"),
                new Reader("Гусев Б.Б",2,"Б","01.01.1991","222"),
                new Reader("Наумов Д.Д",3,"B","01.01.1992","333")
        };      //Массив читателей


        System.out.println("");
        System.out.println("========Сеанс библиотеки открыт===========");
        System.out.println("");

        //Действия читателей
        System.out.println("******************************************");
        for (int i = 0;i<masChit.length;i++){
            masChit[i].takeBook(3);
            masChit[i].takeBook("Приключения", "Словарь", "Энциклопедия");
            masChit[i].takeBook(masKnig[0], masKnig[1], masKnig[2]);

            masChit[i].returnBook(3);
            masChit[i].returnBook("Приключения", "Словарь", "Энциклопедия");
            masChit[i].returnBook(masKnig[0], masKnig[1], masKnig[2]);
            System.out.println("******************************************");
        }

        System.out.println("");
        System.out.println("=============Перечень книг===============");
        for (int i = 0;i<masKnig.length; i++) {

            System.out.println('"' + masKnig[i].getKnigaIma() + '"' +
                    " (" + masKnig[i].getKnigaAvtor() + " " +
                    masKnig[i].getKnigaGod() + ")");
        }
        System.out.println("");
        System.out.println("============Перечень читателей============");
        for (int i = 0;i<masChit.length; i++) {

            System.out.println(masChit[i].getIma()+ " |" +
                    " читательский билет: " + masChit[i].getBiletNomer() + " |" +
                    " факультет: " + masChit[i].getPhakult() + " |" +
                    " год рождения: " + masChit[i].getDatRozhd() + " |" +
                    " тел.: " + masChit[i].getTel());
        }
        System.out.println("");

        System.out.println("========Сеанс библиотеки закрыт===========");

    } //Главный код
}  //Главный класс
