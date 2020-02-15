package tamagotchi;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tamagotchi.personageTamagotchi.PersonageTamagotchi;

public class PlayTamagotchi extends Application {
    PersonageTamagotchi myTomagochi = new PersonageTamagotchi();
    String status;



    @Override
    public void start(Stage primaryStage) throws Exception {

        status = myTomagochi.getStatus();
        if (status == "not"){
            System.out.println("not personage");
        }
        else if (status == "live"){

        }
        else if (status == "did"){

        }


        BorderPane root = new BorderPane();
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);

        Button buttonEat = addButton("Накормить");
        Button buttonPlay = addButton("Поиграть");
        Button buttonZamuchit = addButton("Позлить");
        Button buttonStatistica = addButton("Статистика");
        Button buttonExit = addButton("Выход");

        vbox.getChildren().addAll(buttonEat, buttonPlay, buttonZamuchit, buttonStatistica, buttonExit);
        //root.setRight(vbox);

        if (status == "not"){
            root.setCenter(vbox);
        }
        else if (status == "did"){
            root.setLeft(vbox);
        }
        else {
            root.setRight(vbox);
        }



        Scene scene = new Scene(root, 900, 500);

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