package tamagochi;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import tamagochi.beanTomagochi.PersonTomagchi;

import java.awt.*;

public class MainWindow extends Application {
    PersonTomagchi myTomagochi = new PersonTomagchi();
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
        Button buttonZamuchit = addButton("Поиздеваться");
        Button buttonStatistica = addButton("Статистика");
        Button buttonExit = addButton("Выход");

        vbox.getChildren().addAll(buttonEat, buttonPlay, buttonZamuchit, buttonStatistica, buttonExit);
        root.setRight(vbox);


/*
        primaryStage.setTitle("Tamagochi version 1.01");
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);

        Pane root = new Pane();
        Button buttonStart = new Button();
        buttonStart.setText("Начать игру");
        buttonStart.setTranslateX(0);
        buttonStart.setTranslateY(100);
        buttonStart.setPrefSize(100,20);
        //buttonStart.setOnAction(event-> System.out.println("Hello"));//
        buttonStart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello!!");
            }
        });

        root.getChildren().addAll(buttonStart);
*/

        Scene scene = new Scene(root, 900, 500);

        primaryStage.setScene(scene);
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
