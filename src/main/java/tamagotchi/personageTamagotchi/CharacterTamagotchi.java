package tamagotchi.personageTamagotchi;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import tamagotchi.GameAnimation;
import tamagotchi.PlayTamagotchi;

public class CharacterTamagotchi extends Pane {
    ImageView imageView;
    int offsetX = 0;
    int offsetY = 0;
    int width = 100;
    int height = 100;
    int score = 0;
    Rectangle removeRect = null;
    public GameAnimation animation;
    public CharacterTamagotchi(ImageView imageView){
        this.imageView = imageView;
        this.imageView.setViewport(new Rectangle2D(offsetX,offsetY,width,height));
        animation = new GameAnimation(imageView);
        getChildren().addAll(imageView);
    }

    //передвижение
    public void moveX(int x){
        boolean right = x>0?true:false;
        for(int i = 0; i < Math.abs(x); i++) {
            if ((right)&&(this.getTranslateX()<300)){
                this.setTranslateX(this.getTranslateX() + 1);
            }
            else if(this.getTranslateX()>0){
                this.setTranslateX(this.getTranslateX() - 1);
            }
            Eat();
        }
    }

    //передвижение
    public void moveY(int y) {
        boolean down = y > 0 ? true : false;
        for (int i = 0; i < Math.abs(y); i++) {
            if ((down)&&(this.getTranslateY()<300)) {
                this.setTranslateY(this.getTranslateY() + 1);}
            else if(getTranslateY()>0){
                this.setTranslateY(this.getTranslateY() - 1);
            }
            Eat();
        }
    }

    //еда
    public void Eat(){
        PlayTamagotchi.food.forEach((rect) -> {
            if (this.getBoundsInParent().intersects(rect.getBoundsInParent())) {
                removeRect = rect;
                score++;
                System.out.println(score);
            }

        });
        PlayTamagotchi.food.remove(removeRect);
        PlayTamagotchi.root.getChildren().remove(removeRect);
    }
}
