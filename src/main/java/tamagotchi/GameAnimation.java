package tamagotchi;

import javafx.animation.Transition;
import javafx.scene.image.ImageView;

public class GameAnimation extends Transition {
    private final ImageView imageView;

    public GameAnimation(ImageView imageView){
        this.imageView = imageView;
    }
    protected void interpolate(double frac) {
    }
}
