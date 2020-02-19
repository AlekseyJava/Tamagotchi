package tamagotchi.personageTamagotchi;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import tamagotchi.GameAnimation;
import tamagotchi.PlayTamagotchi;

public class CharacterTamagotchi extends Pane {
    ImageView imageView;
    public GameAnimation animation;
    private int width;
    private int heigth;
    public CharacterTamagotchi(ImageView imageView, int width, int height){
        this.width = width;
        this.heigth = height;
        this.imageView = imageView;
        this.imageView.setFitWidth(width);
        this.imageView.setFitHeight(height);
        animation = new GameAnimation(this.imageView);
        getChildren().addAll(this.imageView);
    }

    //передвижение
    public void moveX(int x){
        boolean right = x>0?true:false;
        for(int i = 0; i < Math.abs(x); i++) {
            if ((right)&&(this.getTranslateX()<550)){
                this.setTranslateX(this.getTranslateX() + 1);
            }
            else if(this.getTranslateX()>0){
                this.setTranslateX(this.getTranslateX() - 1);
            }
            eat();
            //size();
        }
    }

    //передвижение
    public void moveY(int y) {
        boolean down = y > 0 ? true : false;
        for (int i = 0; i < Math.abs(y); i++) {
            if ((down)&&(this.getTranslateY()<550)) {
                this.setTranslateY(this.getTranslateY() + 1);}
            else if(getTranslateY()>0){
                this.setTranslateY(this.getTranslateY() - 1);
            }
            eat();
            //size();
        }
    }

    //еда
    public boolean eat(){
        if ((this.getTranslateX()>500)&&(this.getTranslateY()<50))
        {
            return true;
        }

        else {
            return false;
        }
    }

    public void size(){
        if (heigth <= 100) {
            this.heigth = this.heigth + 1;
            this.width = this.width + 1;
            this.imageView.setFitWidth(this.width);
            this.imageView.setFitHeight(this.heigth);
        }
        else System.out.println("Тамагочи достиг своего максимального размера");;

    }
}
