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
        buttonDog.setPrefSize(100,20);
        GridPane.setConstraints(buttonDog, 0,1);
        Label labelDog = new Label("Ест мясо");
        GridPane.setConstraints(labelDog, 1,1);

        Button buttonCat = new Button("Кошка");
        buttonCat.setPrefSize(100,20);
        GridPane.setConstraints(buttonCat, 0,2);
        Label labelCat = new Label("Ест wiskas");
        GridPane.setConstraints(labelCat, 1,2);

        Button buttonFish = new Button("Рыбка");
        buttonFish.setPrefSize(100,20);
        GridPane.setConstraints(buttonFish, 0,3);
        Label labelFish = new Label("Ест fishfood");
        GridPane.setConstraints(labelFish, 1,3);

        Button buttonTurtle = new Button("Черепаха");
        buttonTurtle.setPrefSize(100,20);
        GridPane.setConstraints(buttonTurtle, 0,4);
        Label labelTurtle = new Label("Ест все");
        GridPane.setConstraints(labelTurtle, 1,4);

        Button buttonBird = new Button("Птичка");
        buttonBird.setPrefSize(100,20);
        GridPane.setConstraints(buttonBird, 0,5);
        Label labelBird = new Label("Ест пшено");
        GridPane.setConstraints(labelBird, 1,5);

        Label selectLabel = new Label("");
        GridPane.setConstraints(selectLabel, 1,10);
        Button selectButton = new Button("Сохранить");
        GridPane.setConstraints(selectButton, 1,11);


        //обрабочик событий

        buttonDog.setOnAction(event -> {
            selectLabel.setText("Выбрана собака");

        });

        buttonCat.setOnAction(event -> {
            selectLabel.setText("Выбрана кошка");
        });

        selectButton.setOnAction(event -> {
            if(selectLabel.getText().equals("")||(selectLabel.getText().equals("Выберите тамаготчи"))){
                selectLabel.setText("Выберите тамаготчи");
            }
            else{
                System.out.println("Сохраняем томагочи");
                //закрываем окно выбора
                //открываем окно игры
            }

        });




        root.getChildren().addAll(label, buttonDog, buttonCat, buttonFish, buttonTurtle, buttonBird);
        root.getChildren().addAll(labelDog, labelCat, labelFish,labelTurtle, labelBird);
        root.getChildren().addAll(selectLabel, selectButton);

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Окно создания персонажа");
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public void select(String[] args){
        launch(args);
    }
}

