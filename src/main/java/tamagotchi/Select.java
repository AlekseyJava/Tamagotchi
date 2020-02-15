package tamagotchi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Select extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();
        Image image = new Image("file:///D://Java//TamagotchiApp//src//main//resources//select.jpg");
        ImageView img = new ImageView(image);

        root.getChildren().addAll(img);
        Scene scene = new Scene(root, 300,300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void Select(String[] args){
        launch(args);
    }
}
