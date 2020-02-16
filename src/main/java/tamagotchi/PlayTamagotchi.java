package tamagotchi;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tamagotchi.personageTamagotchi.PersonageTamagotchi;

import java.util.HashMap;

public class PlayTamagotchi extends Application {
    private HashMap<KeyCode, Boolean> keys = new HashMap<>();
    PersonageTamagotchi myTomagochi = new PersonageTamagotchi();
    String status;

    //-------------------------------------------------------------------------------------------------

    //-------------------------------------------------------------------------------------------------


    @Override
    public void start(Stage primaryStage) throws Exception {



        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
               // update();
              //  bonus();
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

        vbox.getChildren().addAll(buttonEat, buttonPlay, buttonZamuchit, buttonStatistica, buttonExit);
        root.setRight(vbox);


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
