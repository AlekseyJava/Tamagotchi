package tamagotchi.personTamagotchi;

public class PersonageTamagotchi implements Eat, Anger, Play {
    String status; //жив, умер пока нельзя завести нового, завести нового
    int statusHunger; //статус насколько голоден
    int statusSadness;

    public String getStatus() {
        status = "жив";
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
