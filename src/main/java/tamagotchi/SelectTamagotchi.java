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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SelectTamagotchi extends Application {
    private String selectedTamagotchi; //выбраный тамаготчи
    //private LocalDate localDate = LocalDate.now();

    @Override
    public void start(Stage primaryStage) throws Exception {
       GridPane root = new GridPane();
        root.setPadding(new Insets(10,10,10,10));
        root.setHgap(15);
        root.setVgap(15);
        root.getColumnConstraints().add(new ColumnConstraints(120));

        Label label = new Label("Выберите тамагочи");
        //root.getChildren().addAll(label);

        Button buttonDog = new Button();
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


        String url = String.valueOf(ClassLoader.getSystemResource("dog.jpg"));
        Image image = new Image(url);
        ImageView img = new ImageView(image);
        img.setFitWidth(70);
        img.setFitHeight(70);
        buttonDog.setGraphic(img);


        //обрабочик событий

        buttonDog.setOnAction(event -> {
            selectLabel.setText("Выбрана собака");
            selectedTamagotchi = "dog";

        });

        buttonCat.setOnAction(event -> {
            selectLabel.setText("Выбрана кошка");
            selectedTamagotchi = "cat";
        });


        //
        selectButton.setOnAction(event -> {
            if(selectLabel.getText().equals("")||(selectLabel.getText().equals("Выберите тамаготчи"))){
                selectLabel.setText("Выберите тамаготчи");
            }
            else{
                System.out.println("Сохраняем томагочи");
                //сохраняем тамаготчи
                File file = new File("./src/main/resources/status1.txt");
                //String path = String.valueOf(ClassLoader.getSystemResource("status1.txt"));
                //File file = new File(file);

                //LocalDate localDate = LocalDate.now();
                //Date date
                Calendar calendar = new GregorianCalendar();
                Date date = calendar.getTime();

                try(FileWriter writer = new FileWriter(file))
                {
                    // запись всей строки
                    //String text = "Hello Gold!";
                    writer.write("live");
                    //System.getProperty(line.separator);
                    writer.append("\r\n");
                    writer.write(selectedTamagotchi);
                    writer.append("\r\n");
                    writer.write(date.toString()+ "\n");
                    //writer.append('\n');
                    //writer.append('E');

                    writer.flush();
                }
                catch(IOException ex){

                    System.out.println(ex.getMessage());
                }

            }




            //new SelectTamagotchi().open(String[] args);


            //закрываем окно выбора
            //открываем окно игры

        });


        root.getChildren().addAll(label, buttonDog, buttonCat, buttonFish, buttonTurtle, buttonBird);
        root.getChildren().addAll(labelDog, labelCat, labelFish,labelTurtle, labelBird);
        root.getChildren().addAll(selectLabel, selectButton);
        root.getChildren().addAll(img);

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Окно создания персонажа");
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public void selectWindow(String[] args){
        launch(args);
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

