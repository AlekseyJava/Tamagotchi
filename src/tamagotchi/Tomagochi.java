package tamagotchi;

import tamagotchi.personTamagotchi.PersonageTamagotchi;

public class Tomagochi {
    public static void main(String[] args) {

        String status; //не родился, жив, умер
        PersonageTamagotchi tamagotchi = new PersonageTamagotchi();
        status = tamagotchi.getStatus();


        //Тамагочи не родился
        if (status == "select") {
            SelectTamagotchi newTamagotchi = new SelectTamagotchi();
            newTamagotchi.select(args);
        }

        //Тамагочи живет
        if (status == "live"){
            PlayTamagotchi playTamagotchi = new PlayTamagotchi();
            playTamagotchi.buildWindow(args);
        }

        //Тамагочи умер
        if (status == "died"){
            DiedTamagothci diedTamagothci = new DiedTamagothci();
            diedTamagothci.died(args);
        }


    }
}
