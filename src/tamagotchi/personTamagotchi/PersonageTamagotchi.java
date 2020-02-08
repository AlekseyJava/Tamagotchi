package tamagotchi.personTamagotchi;

public class PersonageTamagotchi implements Eat, Anger, Play {
    String status; //завести нового, жив, умер пока нельзя завести нового
    int statusHunger; //статус насколько голоден
    int statusSadness;

    public String getStatus() {

        //status = "не родился";
        status = "жив";
        //status = "умер";
        return status;
    }


    @Override
    public void angerTamagotchi() {
        System.out.println("Злю тамагочи");
    }

    @Override
    public void eatTamagotchi() {
        System.out.println("Идет процесс кормления");

    }

    @Override
    public void playWithTamagotchi() {
        System.out.println("Играю с томагочи");
    }
}
