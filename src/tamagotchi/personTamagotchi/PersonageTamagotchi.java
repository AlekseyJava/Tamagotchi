package tamagotchi.personTamagotchi;

import tamagotchi.Tamagochi;

import java.io.*;
import java.util.Date;

public class PersonageTamagotchi implements Eat, Anger, Play {
    private String status; //завести нового, жив, умер пока нельзя завести нового
    private int statusHunger; //статус насколько голоден
    private int statusSadness; //статус насколько печален
    private String lastFeedingTime; //время последнего кормления

    public String getStatus() {
        //status = "select";
        //status = "live";
        //status = "died";

        //проверка статуса
        //прочитать из файла последнее время кормления,
        // сравнить
        // и если менее x часов статус жив
        // от x часов до y часов статус умер
        // больше y часов - статус выбрать
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("./src//tamagotchi//resource//status.txt")));

            // считаем сначала первую строку

            System.out.println(status = reader.readLine());
            //System.out.println(lastFeedingTime = reader.readLine());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return status;
    }



    public void setStatus(String status) {
        this.status = status;
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

    public Tamagochi statusTamagochi(){
        String myTomagochiStatus;
        String lastFeedingTime;
        Tamagochi tamagochi = new Tamagochi();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("./src//status.txt")));

            // считаем сначала первую строку

            System.out.println(myTomagochiStatus = reader.readLine());
            System.out.println(lastFeedingTime = reader.readLine());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }





        //tamagochi.
        return tamagochi;

    }
}
