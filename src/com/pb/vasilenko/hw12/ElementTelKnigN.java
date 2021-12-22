package com.pb.vasilenko.hw12;

import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

public class ElementTelKnigN {

    public ElementTelKnigN(String ima, List<Integer> spisTel, Date dataRozhd, String adres, Date dataIzmen) {
        this.ima = ima;
        this.spisTel = spisTel;
        this.dataRozhd = dataRozhd;
        this.adres = adres;
        this.dataIzmen = dataIzmen;
    }

    private String ima = "";
    private List<Integer> spisTel;
    private Date dataRozhd;
    private String adres = "";
    private Date dataIzmen;


    public String getIma() {
        return ima;
    }

    public void setIma(String ima) {
        this.ima = ima;
    }

    public List<Integer> getSpisTel() {
        return spisTel;
    }

    public void setSpisTel(List<Integer> spisTel) {
        this.spisTel = spisTel;
    }

    public Date getDataRozhd() {
        return dataRozhd;
    }

    public void setDataRozhd(Date dataRozhd) {
        this.dataRozhd = dataRozhd;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public Date getDataIzmen() {
        return dataIzmen;
    }

    public void setDataIzmen(Date dataIzmen) {
        this.dataIzmen = dataIzmen;
    }

    @Override
    public String toString() {
        return  "ima='" + ima + '\'' +
                PolNomTel() +
                ", dataRozhd=" + dataRozhd +
                ", adres=" + adres;
    }

    private String PolNomTel() {

        KorTel dobKod = (x) -> ", Tel=" + x;
        String nomTel = "";
        for (Integer tel : spisTel) {

            nomTel += dobKod.Vvod(tel);
        }


        return nomTel;
    }

}

@FunctionalInterface
interface KorTel {
    String Vvod(int x);
}
