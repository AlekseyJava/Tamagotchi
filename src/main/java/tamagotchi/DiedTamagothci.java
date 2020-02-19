package tamagotchi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDateTime;

public class DiedTamagothci extends Application {
    private LocalDateTime timeDied;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();

        BufferedReader reader = new BufferedReader(new FileReader(new File("./src//main//resources//status.txt")));
        timeDied = LocalDateTime.parse(reader.readLine());
        System.out.println(timeDied);

        Label labelDied = new Label("Ваш тамагочи умер: " + timeDied.plusDays(1));
        Label labelNewTamagotchi = new Label("Выбрать нового можно будет: " + timeDied.plusDays(4));
        labelNewTamagotchi.setTranslateY(12);

        String url = String.valueOf(ClassLoader.getSystemResource("died.jpg"));
        Image image = new Image(url);
        ImageView img = new ImageView(image);
        img.setFitHeight(200);
        img.setFitWidth(200);

        Label labelImg = new Label();
        labelImg.setGraphic(img);
        labelImg.setTranslateX(25);
        labelImg.setTranslateY(50);

        labelImg.setText("Ваш тамагочи умер: " + timeDied.plusDays(1));
        labelImg.setGraphicTextGap(2);
        labelImg.setContentDisplay(ContentDisplay.BOTTOM);

        root.getChildren().addAll(labelDied, labelNewTamagotchi, labelImg);

        Scene scene = new Scene(root, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Тамагочи умер :-(");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void died(String[] args){
        launch();
    }
}

