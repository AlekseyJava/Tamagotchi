package tamagotchi.personageTamagotchi;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import tamagotchi.GameAnimation;

public class EatTamagotchi extends Pane {
    ImageView imageView;
    private int size;
    public GameAnimation animation;
    public EatTamagotchi(ImageView imageView, int size){
        this.size = size;
        this.imageView = imageView;
        this.imageView.setFitHeight(this.size);
        this.imageView.setFitWidth(this.size);
        this.imageView.setTranslateX(550);
        this.imageView.setTranslateY(0);
        animation = new GameAnimation(imageView);
        getChildren().addAll(imageView);
    }

    public void notFood(){
        //this.setTranslateX();
        this.setTranslateY(-100);
    }

    public void haveFood(){
        this.setTranslateY(0);
    }
}
