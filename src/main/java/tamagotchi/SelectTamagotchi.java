package tamagotchi;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SelectTamagotchi extends Application {
    private String selectedTamagotchi; //выбраный тамаготчи


    @Override
    public void start(Stage primaryStage) throws Exception {
       GridPane root = new GridPane();
        root.setPadding(new Insets(10,10,10,10));
        root.setHgap(15);
        root.setVgap(15);
        root.getColumnConstraints().add(new ColumnConstraints(120));

        Label label = new Label("Выберите тамагочи");

        Button buttonDog = new Button();
        buttonDog.setPrefSize(100,20);
        GridPane.setConstraints(buttonDog, 0,1);
        Label labelDog = new Label("Ест мясо");
        GridPane.setConstraints(labelDog, 1,1);

        Button buttonCat = new Button();
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
        GridPane.setConstraints(selectLabel, 1,7);
        Button selectButton = new Button("Сохранить");
        GridPane.setConstraints(selectButton, 1,8);

        //url = String.valueOf(ClassLoader.getSystemResource("dog.jpg"));
        Image imageDog = new Image(String.valueOf(ClassLoader.getSystemResource("dog.jpg")));
        ImageView imgDog = new ImageView(imageDog);
        imgDog.setFitWidth(50);
        imgDog.setFitHeight(50);
        buttonDog.setGraphic(imgDog);

        Image imageCat = new Image(String.valueOf(ClassLoader.getSystemResource("cat.jpg")));
        ImageView imgCat = new ImageView(imageCat);
        imgCat.setFitWidth(50);
        imgCat.setFitHeight(50);
        buttonCat.setGraphic(imgCat);


        //обрабочик событий
        buttonDog.setOnAction(event -> {
            selectLabel.setText("Выбрана собака");
            selectedTamagotchi = "dog";
        });

        buttonCat.setOnAction(event -> {
            selectLabel.setText("Выбрана кошка");
            selectedTamagotchi = "cat";
        });

        buttonFish.setOnAction(event -> {
            selectLabel.setText("Выбрана рыбка");
            selectedTamagotchi = "fish";
        });

        buttonTurtle.setOnAction(event -> {
            selectLabel.setText("Выбрана черепашка");
            selectedTamagotchi = "turtle";
        });
        buttonBird.setOnAction(event -> {
            selectLabel.setText("Выбрана птичка");
            selectedTamagotchi = "bird";
        });


        //
        selectButton.setOnAction(event -> {
            if(selectLabel.getText().equals("")||(selectLabel.getText().equals("Выберите тамаготчи"))){
                selectLabel.setText("Выберите тамаготчи");
            }
            else{
                System.out.println("Сохраняем томагочи");
                //сохраняем тамаготчи
                File file = new File("./src/main/resources/status.txt");

                LocalDateTime lastEat = LocalDateTime.now();

                try(FileWriter writer = new FileWriter(file))
                {
                    //writer.write("live");
                    //writer.append("\r\n");
                    writer.write(lastEat.toString()+ "\n");
                    writer.append("\r\n");
                    writer.write(selectedTamagotchi);
                    writer.append("\r\n");
                    //writer.write(lastEat.toString()+ "\n");
                    writer.flush();
                }
                catch(IOException ex){

                    System.out.println(ex.getMessage());
                }
            }


            Stage stage = (Stage) selectButton.getScene().getWindow();
            stage.close();
            PlayTamagotchi playTamagotchi = new PlayTamagotchi();
            try {
                playTamagotchi.start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }

        });


        root.getChildren().addAll(label, buttonDog, buttonCat, buttonFish, buttonTurtle, buttonBird);
        root.getChildren().addAll(labelDog, labelCat, labelFish,labelTurtle, labelBird);
        root.getChildren().addAll(selectLabel, selectButton);
        root.getChildren().addAll(imgDog,imgCat);

        Scene scene = new Scene(root, 400, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Окно создания персонажа");
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public void selectWindow(String[] args){
        launch();
        //PlayTamagotchi playTamagotchi = new PlayTamagotchi();
        //playTamagotchi.buildWindow(args);
    }

    public void open(String[] args){
        //PlayTamagotchi playTamagotchi = new PlayTamagotchi();
        //playTamagotchi.buildWindow(args);
        //if (selectedTamagotchi.equals("dog")){

        //}

    }
}

