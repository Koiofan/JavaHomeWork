package com.pb.vasilenko.hw6;

//import java.lang.reflect.Constructor;
//import java.lang.reflect.InvocationTargetException;

public class VetClinic {
    public static void main(String[] args ) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, NoSuchMethodException {

        Animal[] masZhivotn = {
                new Dog("косточка", "будка", "Собачка в ошейнике"),
                new Cat("рыбка", "дом", "Кошка мяукающая"),
                new Horse("сено", "сарай", "Лошадка скачущая"),
        };


        //Рефлексия
        Class vetReflex = Class.forName("com.pb.vasilenko.hw6.Veterinarian");
        //Constructor constrVetReflex = vetReflex.getConstructor(new Class[]{});
        Object obj = vetReflex.newInstance();

        System.out.println("");
        System.out.println("========У ветеринара===========");
        System.out.println("");

        //Поход к ветеринару
        if(obj instanceof Veterinarian) {
            for (int i = 0; i < masZhivotn.length; i++) {

                System.out.println("=====Пришел новый клиент=======");

                String ima = "Неизвестное животное";
                if(masZhivotn[i] instanceof Dog){
                    ima = ((Dog) masZhivotn[i]).getOtlichie();
                }
                else if(masZhivotn[i] instanceof Cat){
                    ima = ((Cat) masZhivotn[i]).getOtlichie();
                }
                else if(masZhivotn[i] instanceof Horse){
                    ima = ((Horse) masZhivotn[i]).getOtlichie();
                }

                System.out.print(ima);

                ((Veterinarian) obj).treatAnimal(masZhivotn[i]);

                System.out.println("********Характеристика********");

                masZhivotn[i].makeNoise(ima);
                masZhivotn[i].eat(ima);
                masZhivotn[i].sleep(ima);


                System.out.println("");
            }
        }

        System.out.println("========Спасибо за визит!===========");
        System.out.println("");

    }
}
