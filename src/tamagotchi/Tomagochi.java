package tamagotchi;

import tamagotchi.personTamagotchi.PersonageTamagotchi;

public class Tomagochi {
    public static void main(String[] args) {

        String status; //не рожден, жив, умер
        PersonageTamagotchi tamagotchi = new PersonageTamagotchi();
        status = tamagotchi.getStatus();

        if (status == "not tamagotchi") {
            System.out.println("не родился");
        }

        if (status == "жив"){
            PlayWindow playWindow = new PlayWindow();
            playWindow.buildWindow(args);
        }

        if (status == "умер"){
            System.out.println("умер");
        }


    }
}
