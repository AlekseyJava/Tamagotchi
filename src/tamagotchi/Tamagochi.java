package tamagotchi;

import tamagotchi.personTamagotchi.PersonageTamagotchi;

import java.io.*;
import java.util.Date;

public class Tamagochi {
    public static void main(String[] args) {
        String status; //не родился, жив, умер

        PersonageTamagotchi tamagotchi = new PersonageTamagotchi();
        status = tamagotchi.getStatus();


        //Тамагочи не родился
        if (status.equals("select")) {
            SelectTamagotchi newTamagotchi = new SelectTamagotchi();
            newTamagotchi.select(args);
        }

        //Тамагочи живет
        if (status.equals("live")){
            PlayTamagotchi playTamagotchi = new PlayTamagotchi();
            playTamagotchi.buildWindow(args);
        }

        //Тамагочи умер
        if (status.equals("died")){
            DiedTamagothci diedTamagothci = new DiedTamagothci();
            diedTamagothci.died(args);
        }


    }


}