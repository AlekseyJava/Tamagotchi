package tamagotchi;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SelectTamagotchi extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane root = new GridPane();
        root.setPadding(new Insets(10,10,10,10));
        root.setHgap(15);
        root.setVgap(15);
        root.getColumnConstraints().add(new ColumnConstraints(120));

        Label label = new Label("Выберите тамагочи");
        //root.getChildren().addAll(label);

        Button buttonDog = new Button("Собака");
        //buttonDog.setMaxHeight(100);
        GridPane.setConstraints(buttonDog, 0,1);
        Label labelDog = new Label("Ест мясо");
        GridPane.setConstraints(labelDog, 1,1);
        Button buttonCat = new Button("Кошка");
        GridPane.setConstraints(buttonCat, 0,2);
        Button buttonFish = new Button("Рыбка");
        GridPane.setConstraints(buttonFish, 0,3);
        Button buttonTurtle = new Button("Черепаха");
        GridPane.setConstraints(buttonTurtle, 0,4);
        Button buttonBird = new Button("Птичка");
        GridPane.setConstraints(buttonBird, 0,5);


        root.getChildren().addAll(label, buttonDog, buttonCat, buttonFish, buttonTurtle, buttonBird);
        root.getChildren().addAll(labelDog);

        Scene scene = new Scene(root, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Окно создания персонажа");
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public void select(String[] args){
        launch(args);
    }
}
