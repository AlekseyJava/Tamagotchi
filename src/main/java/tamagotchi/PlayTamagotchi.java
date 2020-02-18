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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class PlayTamagotchi extends Application {
    private HashMap<KeyCode, Boolean> keys = new HashMap<>();
    boolean eats = false;

    //-------------------------------------------------------------------------------------------------
    Image imageTypeTomogochi;
    {
        try {
            //считывание status
            imageTypeTomogochi = new Image(new FileInputStream("./src/main/resources/dog.jpg"));
        } catch (FileNotFoundException e) { e.printStackTrace(); }
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

    CharacterTamagotchi player = new CharacterTamagotchi(imagePerson);
    EatTamagotchi footTamagotchi = new EatTamagotchi(imageFood);

    public void eat(){
        footTamagotchi.animation.play();
    }



    public void update() {
        if (isPressed(KeyCode.UP)) {
            player.animation.play();
            player.moveY(-1);
        } else if (isPressed(KeyCode.DOWN)) {
            player.animation.play();
            player.moveY(1);
        } else if (isPressed(KeyCode.RIGHT)) {
            player.animation.play();
            player.moveX(1);
        } else if (isPressed(KeyCode.LEFT)) {
            player.animation.play();
            player.moveX(-1);
        }
        else{
            player.animation.stop();
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
                if (eats) eat();
                update();
            }
        };


        BorderPane root = new BorderPane();
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.BOTTOM_CENTER);

        Label label = new Label("my label");

        Button buttonEat = addButton("Накормить");
        Button buttonPlay = addButton("Поиграть");
        buttonPlay.setDisable(true);
        Button buttonZamuchit = addButton("Позлить");
        buttonZamuchit.setDisable(true);
        Button buttonExit = addButton("Выход");

        Button buttonFood = new Button("Food");
        Button buttonToy = new Button("Toy");
        Button buttonZZZ = new Button("RRR..");


        buttonEat.setOnAction(event -> {
            buttonFood.setPrefSize(50,50);
            BorderPane.setAlignment(buttonFood, Pos.TOP_RIGHT);
            root.setCenter(buttonFood);
            System.out.println("Кормление");
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

        if (eats){
            buttonFood.setBackground(Background.EMPTY);
            System.out.println("ем ням ням");
        }

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
