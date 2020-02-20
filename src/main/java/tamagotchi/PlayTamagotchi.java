package tamagotchi;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import tamagotchi.personageTamagotchi.CharacterTamagotchi;
import tamagotchi.personageTamagotchi.EatTamagotchi;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class PlayTamagotchi extends Application {
    private HashMap<KeyCode, Boolean> keys = new HashMap<>();
    boolean eats = false;
    boolean food = false;
    int sizePersonage = 50;
    int sizeFood = 50;
    LocalDateTime lastFeedingTime;
    String typeTamagotchi;

    //-------------------------------------------------------------------------------------------------
    Image imageTypeTomogochi;
    {
        try {
            //считывание картинки
            BufferedReader reader = new BufferedReader(new FileReader(new File("./src//main//resources//status.txt")));
            lastFeedingTime = LocalDateTime.parse(reader.readLine());
            System.out.println(lastFeedingTime);
            System.out.println(reader.readLine());
            typeTamagotchi = reader.readLine();
            System.out.println(typeTamagotchi);

            if(typeTamagotchi.equals("dog")){
                imageTypeTomogochi = new Image(new FileInputStream("./src/main/resources/dog.jpg"));
            }

            if(typeTamagotchi.equals("cat")){
                imageTypeTomogochi = new Image(new FileInputStream("./src/main/resources/cat.jpg"));
            }

            if(typeTamagotchi.equals("fish")){
                imageTypeTomogochi = new Image(new FileInputStream("./src/main/resources/fish.jpg"));
            }

            if(typeTamagotchi.equals("turtle")){
                imageTypeTomogochi = new Image(new FileInputStream("./src/main/resources/turtle.jpg"));
            }

            if(typeTamagotchi.equals("bird")){
                imageTypeTomogochi = new Image(new FileInputStream("./src/main/resources/bird.jpg"));
            }


        } catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Image imageFoodTomagochi;
    {
        try {
            //считывание status
            imageFoodTomagochi = new Image(new FileInputStream("./src/main/resources/food.jpg"));
        } catch (FileNotFoundException e) { e.printStackTrace(); }

    }
    ImageView imagePerson = new ImageView(imageTypeTomogochi);
    ImageView imageFood = new ImageView(imageFoodTomagochi);

    CharacterTamagotchi player = new CharacterTamagotchi(imagePerson, sizePersonage, sizePersonage);
    EatTamagotchi footTamagotchi = new EatTamagotchi(imageFood, sizeFood);

    public void eat(){
        if (food == false){
            //System.out.println("Еды нет");
            footTamagotchi.animation.play();
            footTamagotchi.notFood();
        }

        if ((food)&&(eats)){
            //System.out.println("Еда есть кушаю");
            food = false;
            footTamagotchi.animation.play();
            footTamagotchi.notFood();
            player.size();
        }

        if ((food)&&(eats == false)){
            //System.out.println("Еда есть не скормлена");
            footTamagotchi.animation.play();

        }
    }


    public void update() {
        if (isPressed(KeyCode.UP)) {
            player.animation.play();
            player.moveY(-1);
            eats = player.eat();
        } else if (isPressed(KeyCode.DOWN)) {
            player.animation.play();
            player.moveY(1);
            eats = player.eat();
        } else if (isPressed(KeyCode.RIGHT)) {
            player.animation.play();
            player.moveX(1);
            eats = player.eat();
        } else if (isPressed(KeyCode.LEFT)) {
            player.animation.play();
            player.moveX(-1);
            eats = player.eat();
        }
        else{
            player.animation.stop();
            eats = player.eat();
        }
    }
    public boolean isPressed(KeyCode key) {
        return keys.getOrDefault(key, false);
    }

    //-------------------------------------------------------------------------------------------------


    @Override
    public void start(Stage primaryStage) throws Exception {

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                eat();
                update();
            }
        };


        BorderPane root = new BorderPane();
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.BOTTOM_CENTER);

        Label label = new Label("lastFeedingTime");

        Button buttonEat = addButton("Накормить");
        Button buttonPlay = addButton("Поиграть");
        buttonPlay.setDisable(true);
        Button buttonZamuchit = addButton("Позлить");
        buttonZamuchit.setDisable(true);
        Button buttonExit = addButton("Выход");


        buttonEat.setOnAction(event -> {
            food = true;
            System.out.println("Кормление");
            footTamagotchi.haveFood();
            lastFeedingTime = LocalDateTime.now();
            label.setText(lastFeedingTime.toString());
        });

        buttonExit.setOnAction(event ->{
            primaryStage.close();
        });

        vbox.getChildren().addAll(label,buttonEat, buttonPlay, buttonZamuchit, buttonExit);
        root.setRight(vbox);

        root.getChildren().addAll(player, footTamagotchi);

        Scene scene = new Scene(root, 900, 500);
        scene.setOnKeyPressed(event->keys.put(event.getCode(),true));
        scene.setOnKeyReleased(event-> {
            keys.put(event.getCode(), false);
        });

        timer.start();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tamagotchi 1.01");
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.show();

    }

    private Button addButton(String name){
        Button btn = new Button(name);
        btn.setPrefSize(300,100);
        return btn;
    }

    public static void buildWindow() {
        launch();
    }
}
