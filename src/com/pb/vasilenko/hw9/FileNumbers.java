package com.pb.vasilenko.hw9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class FileNumbers {
    public static void main(String[] args) throws IOException {

        //Переменные
        String imaFile = "numbers.txt";
        String imaFileZamen = "odd-numbers.txt";
        int qStrok = 10;
        int qChisl = 10;

        createNumbersFile(imaFile, qStrok, qChisl);             //Запись файла
        createOddNumbersFile(imaFile, imaFileZamen, qStrok);    //Чтение-замена файла

    }

    //Запись файла
    private static void createNumbersFile(String imaFile, int qStrokDan, int qChislDan) {

        Random random = new Random();
        Path puthFile = Paths.get(imaFile);
        try (BufferedWriter writer = Files.newBufferedWriter(puthFile)) {

            for (int qStrok = 0; qStrok < qStrokDan; qStrok++) {
                for (int qChisl = 0; qChisl < qChislDan; qChisl++) {
                    String chisloSTR = Integer.toString(random.nextInt(99) + 1);
                    writer.write(chisloSTR);

                    if(qChisl == qStrokDan-1)
                    {
                        continue;
                    }

                    writer.write(" ");
                }
                writer.newLine();
            }

        } catch (Exception ex) {
            System.out.println("Ошибка записи: " + ex);
        }
    }

    //Чтение-замена файла
    private static void createOddNumbersFile(String imaFile, String imaFileZamen, int qStrokDan) {

        Path puthFile = Paths.get(imaFile);
        Path puthFileZamen = Paths.get(imaFileZamen);

        try (BufferedWriter writer = Files.newBufferedWriter(puthFileZamen)) {

            try (BufferedReader reader = Files.newBufferedReader(puthFile)) {
                String line;
                while ((line = reader.readLine()) != null) {

                    String[] masStr = line.split(" ");
                    int MasInt[] = new int[masStr.length];


                    for (int qChisl = 0; qChisl < masStr.length; qChisl++) {
                        MasInt[qChisl] = Integer.parseInt(masStr[qChisl]);

                        if (MasInt[qChisl] % 2 == 0) {
                            MasInt[qChisl] = 0;
                        }

                        writer.write(Integer.toString(MasInt[qChisl]));

                        if(qChisl == MasInt.length-1)
                        {
                            continue;
                        }

                        writer.write(" ");

                    }
                    writer.newLine();


                }

            } catch (Exception ex) {
                System.out.println("Ошибка замены: " + ex);
            }


        } catch (Exception ex) {
            System.out.println("Ошибка записи замены: " + ex);
        }


    }

}
