package tamagotchi.personageTamagotchi;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import tamagotchi.GameAnimation;

public class EatTamagotchi extends Pane {
    ImageView imageView;
    public GameAnimation animation;
    public EatTamagotchi(ImageView imageView){
        this.imageView = imageView;
        this.imageView.setFitHeight(50);
        this.imageView.setFitWidth(50);
        this.imageView.setTranslateX(550);
        this.imageView.setTranslateY(0);
        animation = new GameAnimation(imageView);
        getChildren().addAll(imageView);
    }
}
