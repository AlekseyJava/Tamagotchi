package tamagotchi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DiedTamagothci extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();

        Label labelDied = new Label("Ваш тамагочи умер: и точное время смерти.");
        Label labelNewTamagotchi = new Label("Выбрать нового можно будет: и точное время выбора");
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

        labelImg.setText("Ваш тамагочи умер: " + "время смерти томагочи");
        labelImg.setGraphicTextGap(2);
        labelImg.setContentDisplay(ContentDisplay.BOTTOM);
        //labelImg.setText("Выбрать нового можно будет, через: " + "время выбора нового" );
        //labelImg.setGraphicTextGap(2);
        //labelImg.setContentDisplay(ContentDisplay.TOP);

        root.getChildren().addAll(labelDied, labelNewTamagotchi, labelImg);





        Scene scene = new Scene(root, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Тамагочи умер :-(");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void died(String[] args){
        launch(args);
    }
}

