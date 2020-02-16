package tamagotchi;

import tamagotchi.personageTamagotchi.PersonageTamagotchi;

public class Tamagotchi {
    public static void main(String[] args) {
        String status; //не родился(не выбран), жив, умер

        PersonageTamagotchi tamagotchi = new PersonageTamagotchi();
        status = tamagotchi.getStatus();


        //Тамагочи не родился(не выбран)
        if (status.equals("select")) {
            SelectTamagotchi newTamagotchi = new SelectTamagotchi();
            newTamagotchi.selectWindow(args);
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
