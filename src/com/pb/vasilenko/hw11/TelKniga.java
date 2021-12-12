package com.pb.vasilenko.hw11;

//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;

//import static com.pb.vasilenko.hw7.Size.L;


public class TelKniga {

    static Scanner scan = new Scanner(System.in);
    static ArrayList<ElementTelKnig> spisokKontaktov = new ArrayList<>();
    static ObjectMapper mapper = new ObjectMapper();
    static String imaTelKnig = "TelKniga.kng";

    public static void main(String[] args) throws ParseException, IOException, ClassNotFoundException {
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        System.out.println("");
        System.out.println("==========Телефонная книга=======");
        System.out.println("");

        while (true){
            System.out.println("==========Дейстивя: =======");
            System.out.println("Добавить контакт: нажмите 1.");
            System.out.println("Найти контакт: нажмите 2.");
            System.out.println("Изменить контакт: нажмите 3.");
            System.out.println("Вывести контакты по алфавиту: нажмите 4.");
            System.out.println("Вывести контакты по дате рождения: нажмите 5.");
            System.out.println("Удалить контакт: нажмите 10.");
            System.out.println("Сохранить контакты: нажмите 6.");
            System.out.println("Загрузить контакты: нажмите 7.");
            System.out.println("Выход: нажмите 0.");
            System.out.println("");
            System.out.println("==========Сделайте ваш выбор=======");
            String Str = scan.nextLine().toLowerCase();
            System.out.println("");
            if(Str.equals("1")){
                System.out.println("Добавление контакта.");
                KontaktDobav();  //Добавление контакта
            }else if(Str.equals("2")){
                System.out.println("Поиск контакта.");
                KontaktPoisk();  //Поиск контакта
            }else if(Str.equals("3")){
                System.out.println("Изменение контакта.");
                KontaktIzmen();  //Изменение контакта
            }else if(Str.equals("4")){
                System.out.println("Сортировка по имени.");
                SortKontakt("i");  //Сортировка по имени
            }else if(Str.equals("5")){
                System.out.println("Сортировка по дате рождения.");
                SortKontakt("d");  //Сортировка по дате рождения
            }else if(Str.equals("6")){
                System.out.println("Сохранение контактов");
                SoranTelKniga(imaTelKnig);  //Сохранение контактов
            }else if(Str.equals("7")){
                System.out.println("Загрузка контактов.");
                ZagruzTelKniga(imaTelKnig);  //Загрузка контактов
            }
            else if(Str.equals("10")){
                System.out.println("Удаление контакта.");
                KontaktUdal();   //Удаление котнакта
            }
            else if(Str.equals("0")){
                break;
            }else {
                System.out.println("Неправильный ввод!");
                System.out.println("");
            }
        }

        System.out.println("==========Телефонная книга закрыта.=======");
        System.out.println("");

    }

    //Добавление контакта
    private static void KontaktDobav() throws ParseException {

        String ima = "";
        ArrayList<Integer> spisTel = new ArrayList<Integer>();
        Date dataRozhd;
        String adres = "";
        Date dataIzmen;

        System.out.println("==========Введите имя=======");
        ima = scan.nextLine();
        System.out.println("==========Введите дату рождения (13.01.2000) =======");
        dataRozhd = new SimpleDateFormat("dd.MM.yyyy").parse(scan.nextLine());
        System.out.println("==========Введите адрес=======");
        adres = scan.nextLine();
        dataIzmen = new Date();

        while (true){
            System.out.println("==========Введите номер телефона (0971234567)=======");
            spisTel.add(Integer.parseInt(scan.nextLine()));

            System.out.println("==========Добавить другой номер телефона?(y|any key)=======");
            String Str = scan.nextLine().toLowerCase();
            if(!Str.equals("y") && !Str.equals("н")){
                break;
            }

        }


        spisokKontaktov.add(new ElementTelKnig(ima, spisTel, dataRozhd, adres, dataIzmen));
        System.out.println("");
        System.out.println("==========Контакт добавлен=======");
        System.out.println("");
    }

    //Удаление контакта
    private static void KontaktUdal(){

        System.out.println("==========Введите имя=======");
        String ima = scan.nextLine();
        boolean rezPoisk = false;

        for (int indKontakt = 0; indKontakt < spisokKontaktov.size();indKontakt++) {

            if(spisokKontaktov.get(indKontakt).getIma().equals(ima)){
                spisokKontaktov.remove(indKontakt);
                rezPoisk = true;
                System.out.println("");
                System.out.println("==========Контакт удален=======");
                System.out.println("");
                break;
            }


        }

        if(!rezPoisk){
            System.out.println("");
            System.out.println("==========Контакт не найден при удалении=======");
            System.out.println("");
        }

    }


    //Поиск контакта
    private static int KontaktPoisk(){

        int ind = -1;
        System.out.println("==========Введите имя=======");
        String ima = scan.nextLine();
        boolean rezPoisk = false;


        for (int indKontakt = 0; indKontakt < spisokKontaktov.size();indKontakt++) {

            if(spisokKontaktov.get(indKontakt).getIma().equals(ima)){
                System.out.println("==========Контакт найден=======");
                System.out.println("");
                System.out.println(spisokKontaktov.get(indKontakt).toString());
                rezPoisk = true;
                ind = indKontakt;
                break;
            }
        }

        if(!rezPoisk){
            System.out.println("==========Контакт не найден=======");
            System.out.println("");
        }

       return ind;
    }


    //Изменение контакта
    private static void KontaktIzmen(){

        int indKontakt = KontaktPoisk();  //Поиск контакта

        if(indKontakt != -1){

            System.out.println("");
            System.out.println("==========Что изменить? (ima i|adres a)=======");

            String Str = scan.nextLine().toLowerCase();
            if(Str.equals("i") || Str.equals("ш")){
                System.out.println("==========Введите имя=======");
                spisokKontaktov.get(indKontakt).setIma(scan.nextLine());
                System.out.println("");
                System.out.println("==========Имя изменено=======");
                System.out.println("");
            }
            else if(Str.equals("a") || Str.equals("ф")){
                System.out.println("==========Введите адрес=======");
                spisokKontaktov.get(indKontakt).setAdres(scan.nextLine());
                System.out.println("");
                System.out.println("==========Адрес изменен=======");
                System.out.println("");
            }

        }

    }


    //Сортировка
    private static void SortKontakt(String tipSort){

        if(tipSort.equals("i")){
            Set<String> spisImaSet = new TreeSet<>();
            for (ElementTelKnig kontakt : spisokKontaktov) {
                spisImaSet.add(kontakt.getIma());
            }

            for (String ima : spisImaSet){
                System.out.println(ima);
            }

        } else if(tipSort.equals("d")){
            Set<Date> spisDataSet = new TreeSet<>();
            for (ElementTelKnig kontakt : spisokKontaktov) {
                spisDataSet.add(kontakt.getDataRozhd());
            }

            for (Date data : spisDataSet){

                for (ElementTelKnig kontakt : spisokKontaktov) {
                    if(kontakt.getDataRozhd().equals(data)){
                        System.out.println(kontakt.getIma());
                    }
                }

            }

        }

    }

    //Сохранение телефонной книги
    private static void SoranTelKniga(String imaTelKnig) throws IOException {

        String strJSON = mapper.writeValueAsString(spisokKontaktov);

        File imaTelKniga = Paths.get(imaTelKnig).toFile();
        FileOutputStream outputStream = new FileOutputStream(imaTelKniga);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(strJSON);
        objectOutputStream.close();

        System.out.println("==========Контакты сохранены.=======");
        System.out.println("");

    }

    //Загрузка телефонной книги
    private static void ZagruzTelKniga(String imaTelKnig) throws IOException, ClassNotFoundException {
        File file = Paths.get(imaTelKnig).toFile();
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        String strJSON = (String) objectInputStream.readObject();

        ArrayList<LinkedHashMap>spisokKontaktovLHM = mapper.readValue(strJSON, ArrayList.class);

        spisokKontaktov = new ArrayList<>();
        for (int nomK = 0; nomK < spisokKontaktovLHM.size(); nomK++ ) {
            spisokKontaktov.add(new ElementTelKnig((String) spisokKontaktovLHM.get(nomK).get("ima"),
            (List<Integer>) spisokKontaktovLHM.get(nomK).get("spisTel"), new Date((Long) spisokKontaktovLHM.get(nomK).get("dataRozhd")),
            (String)spisokKontaktovLHM.get(nomK).get("adres"), new Date ((Long) spisokKontaktovLHM.get(nomK).get("dataIzmen"))
            ));
        }


        System.out.println("==========Контакты загружены.=======");
        System.out.println("");
    }

}
