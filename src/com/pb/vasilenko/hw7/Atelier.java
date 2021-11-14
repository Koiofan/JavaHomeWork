package com.pb.vasilenko.hw7;

public class Atelier {
    public static void main(String[] args) {

        Clothes[] masOdezhda = {
                new Tshirt(Size.XS, 30.11, "белый"),
                new Pants(Size.S, 100.32, "черный"),
                new Skirt(Size.M, 50.53, "красная"),
                new Tie(Size.L, 80.44, "фиолетовый")
        };

        System.out.println("=========В ателье==============");
        System.out.println();

        System.out.println("=========Мужской отдел==============");
        dressMan(masOdezhda);

        System.out.println();

        System.out.println("=========Женский отдел==============");
        dressWomen(masOdezhda);

        System.out.println();
        System.out.println("========Спасибо!==============");
        System.out.println();
    }

    public static void dressMan(Clothes[] clothes) {

        for (int i = 0; i < clothes.length; i++) {
            if (clothes[i] instanceof Tshirt) {
                ((Tshirt) clothes[i]).dressMan();
            }
            if (clothes[i] instanceof Pants) {
                ((Pants) clothes[i]).dressMan();
            }
            if (clothes[i] instanceof Tie) {
                ((Tie) clothes[i]).dressMan();
            }
        }
    }

    public static void dressWomen(Clothes[] clothes) {
        for (int i = 0; i < clothes.length; i++) {
            if (clothes[i] instanceof Tshirt) {
                ((Tshirt) clothes[i]).dressWomen();
            }
            if (clothes[i] instanceof Pants) {
                ((Pants) clothes[i]).dressWomen();
            }
            if (clothes[i] instanceof Skirt) {
                ((Skirt) clothes[i]).dressWomen();
            }
        }
    }
}
