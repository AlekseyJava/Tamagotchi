package tamagotchi;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class PlayTamagotchi extends Application {
    private HashMap<KeyCode, Boolean> keys = new HashMap<>();
    //public static ArrayList<Rectangle> food = new ArrayList<>();
    boolean eats = false;
    //PersonageTamagotchi myTomagochi = new PersonageTamagotchi();
    //String status;

    //-------------------------------------------------------------------------------------------------

    //private HashMap<KeyCode, Boolean> keys = new HashMap<>();
    //public static ArrayList<Rectangle> food = new ArrayList<>();

    Image image;
    {
        try {
            image = new Image(new FileInputStream("Z:\\dog.jpg"));
        } catch (FileNotFoundException e) { e.printStackTrace(); }
    }
    ImageView imageView = new ImageView(image);

    CharacterTamagotchi player = new CharacterTamagotchi(imageView);

    public boolean eat(){
        return
     eats = player.Eat();
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
                update();
                eat();
            //    play();
            //    anger();
               if (eats){
                   //buttonFood.setPrefSize(100,100);

                }
            }
        };


        BorderPane root = new BorderPane();
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);

        Button buttonStatus = addButton("Статус");
        Button buttonEat = addButton("Накормить");
        Button buttonPlay = addButton("Поиграть");
        Button buttonZamuchit = addButton("Позлить");
        Button buttonExit = addButton("Выход");

        Button buttonFood = new Button("Food");
        Button buttonToy = new Button("Toy");
        Button buttonZZZ = new Button("RRR..");


        buttonEat.setOnAction(event -> {
            buttonFood.setPrefSize(100,100);
            BorderPane.setAlignment(buttonFood, Pos.TOP_RIGHT);
            root.setCenter(buttonFood);
            System.out.println("Кормление");
        });

        buttonExit.setOnAction(event ->{
            primaryStage.close();
        });

        vbox.getChildren().addAll(buttonStatus, buttonEat, buttonPlay, buttonZamuchit, buttonExit);
        root.setRight(vbox);

        root.getChildren().addAll(player);
        //root.getChildren().addAll(food);


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
