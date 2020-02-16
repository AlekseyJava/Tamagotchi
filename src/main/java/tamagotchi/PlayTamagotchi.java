package tamagotchi;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import tamagotchi.personageTamagotchi.CharacterTamagotchi;
import tamagotchi.personageTamagotchi.PersonageTamagotchi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class PlayTamagotchi extends Application {
    private HashMap<KeyCode, Boolean> keys = new HashMap<>();
    public static ArrayList<Rectangle> food = new ArrayList<>();
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


    //ImageView imageView = new ImageView(new File("1.png").toURI().toString());
    CharacterTamagotchi player = new CharacterTamagotchi(imageView);
    public static Pane root = new Pane();

    public void eat(){
        int random = (int)Math.floor(Math.random()*100);
        int x = (int)Math.floor(Math.random()*300);
        int y = (int)Math.floor(Math.random()*300);
        if(random == 5){
            Rectangle rect = new Rectangle(50,50, Color.BLUE);
            rect.setX(x);
            rect.setY(y);
            food.add(rect);
            //root.getChildren().add(rect);
        }
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
            }
        };



        BorderPane root = new BorderPane();
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);

        Button buttonEat = addButton("Накормить");
        Button buttonPlay = addButton("Поиграть");
        Button buttonZamuchit = addButton("Позлить");
        Button buttonStatistica = addButton("Статистика");
        Button buttonExit = addButton("Выход");

        Button buttonFood = new Button("Food");
        //buttonFood.setPrefSize(150,150);
        //buttonFood.setTranslateX(200);
        //buttonFood.setTranslateY(200);
        Button top = new Button("Top");
        BorderPane.setAlignment(top, Pos.CENTER);


        buttonEat.setOnAction(event -> {
            buttonFood.setPrefSize(100,100);
            BorderPane.setAlignment(buttonFood, Pos.CENTER);
            System.out.println("Кормление");
            //root.getChildren().addAll(buttonFood);
        });

        vbox.getChildren().addAll(buttonEat, buttonPlay, buttonZamuchit, buttonStatistica, buttonExit);
        root.setRight(vbox);
        root.setCenter(buttonFood);
        //root.getChildren().addAll(buttonFood);
        //root.getChildren(buttonFood);
        root.getChildren().addAll(player);


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

    public static void buildWindow(String[] args) {
        launch(args);
    }
}
