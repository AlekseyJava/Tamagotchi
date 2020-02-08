package tamagotchi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DiedTamagothci extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Тамагочи умер :-(");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void died(String[] args){
        launch(args);
    }
}
