package tamagotchi.personageTamagotchi;

import java.io.*;
import java.time.LocalDateTime;

public class PersonageTamagotchi implements Eat, Anger, Play {
    private String status; //завести нового, жив, умер пока нельзя завести нового
    //private int statusHunger; //статус насколько голоден
    //private int statusSadness; //статус насколько печален
    private LocalDateTime lastFeedingTime; //время последнего кормления


    public String getStatus() {
        //status = "select","live","died";
        //проверка статуса
        //прочитать из файла последнее время кормления,
        // сравнить
        // и если менее 1 суток статус live
        // от 1 суток до 4 суток статус died
        // больше 4 суток - статус select
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("./src//main//resources//status.txt")));
            lastFeedingTime = LocalDateTime.parse(reader.readLine());
            System.out.println(lastFeedingTime);
            //lastFeedingTime.plusDays(1);
            if(lastFeedingTime.plusDays(1).compareTo(LocalDateTime.now())>0){
                status = "live";
            }
            else if(lastFeedingTime.plusDays(1).compareTo(LocalDateTime.now())<0){
                if (lastFeedingTime.plusDays(4).compareTo(LocalDateTime.now())<0){
                    status = "select";
                }
                else status = "died";
            }

            System.out.println(status);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            status = "select";
        } catch (IOException e) {
            status = "select";
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
/*
    public Tamagotchi statusTamagochi(){
        String myTomagochiStatus;
        String lastFeedingTime;
        Tamagotchi tamagochi = new Tamagotchi();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("./src//main//resources//status.txt")));

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
    */
}

