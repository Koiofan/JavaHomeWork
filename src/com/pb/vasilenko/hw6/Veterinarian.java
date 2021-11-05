package com.pb.vasilenko.hw6;

public class Veterinarian {
     void treatAnimal(Animal animal){
        System.out.println(" кушает еду " + '"' + animal.getFood()+ '"' +
                " в месте " + '"' + animal.getLocation()+ '"' +  ".");
    }
}
