package com.pb.vasilenko.hw5;

public class Reader {

    private String ima;
    private int biletNomer;
    private String phakult;
    private String datRozhd;
    private String tel;

    //Конструктор
   public Reader(String ima, int biletNomer, String phakult, String datRozhd, String tel){
       setIma(ima);
       setBiletNomer(biletNomer);
       setPhakult(phakult);
       setDatRozhd(datRozhd);
       setTel(tel);
   }

    //Установка
    public void setIma(String ima){
        this.ima = ima;
    }

    public void setBiletNomer(int biletNomer){
        this.biletNomer = biletNomer;
    }

    public void setPhakult(String phakult){
        this.phakult = phakult;
    }

    public void setDatRozhd(String datRozhd){
        this.datRozhd = datRozhd;
    }

    public void setTel(String tel){
        this.tel = tel;
    }


    //Получение
    public String  getIma(){
        return this.ima;
    }

    public int getBiletNomer(){
        return this.biletNomer;
    }

    public String getPhakult(){
        return this.phakult;
    }

    public String getDatRozhd(){
        return this.datRozhd;
    }

    public String getTel(){
        return this.tel;
    }


    //Методы
    public void takeBook(int qKnig) {
        System.out.println(ima + " взял " + qKnig + " книги.");
    }

    public void takeBook(String ... masImaKnig){
        System.out.print(ima + " взял книги:");

        for (int i = 0;i<masImaKnig.length;i++){
            System.out.print(" " + '"' + masImaKnig[i] + '"');

            if(i < masImaKnig.length - 1){
                System.out.print(",");
            }

        }

        System.out.println(".");

    }

    public void takeBook(Book ...masKnig) {
        System.out.print(ima + " взял книги:");

        for (int i = 0; i < masKnig.length; i++) {
            System.out.print(" " + '"' + masKnig[i].getKnigaIma() + '"' + "(" +
                    masKnig[i].getKnigaAvtor() + " " +
                    masKnig[i].getKnigaGod() + ")");

            if (i < masKnig.length - 1) {
                System.out.print(",");
            }

        }

        System.out.println(".");
    }

    public void returnBook(int qKnig) {
        System.out.println(ima + " вернул " + qKnig + " книги.");
    }

    public void returnBook(String ... masImaKnig){
        System.out.print(ima + " вернул книги:");

        for (int i = 0;i<masImaKnig.length;i++){
            System.out.print(" " + '"' + masImaKnig[i] + '"');

            if(i < masImaKnig.length - 1){
                System.out.print(",");
            }

        }

        System.out.println(".");

    }

    public void returnBook(Book ...masKnig) {
        System.out.print(ima + " вернул книги:");

        for (int i = 0; i < masKnig.length; i++) {
            System.out.print(" " + '"' + masKnig[i].getKnigaIma() + '"' + "(" +
                    masKnig[i].getKnigaAvtor() + " " +
                    masKnig[i].getKnigaGod() + ")");

            if (i < masKnig.length - 1) {
                System.out.print(",");
            }

        }

        System.out.println(".");
    }

}
