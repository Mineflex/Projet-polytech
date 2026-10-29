package coreProtector.entity.mobs;
import coreProtector.entity.Entity;
import coreProtector.gameGestion.GamePanel;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;
import java.awt.*;
import java.util.Random;

public class Slime extends Entity {


    public Slime(GamePanel gp) {
        super(gp);

        name= "Slime Lvl1";
        speed =1;
        maxLife=5;
        life=maxLife;

        hitBox=new Rectangle(0 + gp.scale *8*sizeMultiplier,0 + gp.scale *8*sizeMultiplier ,gp.scale*16*sizeMultiplier,gp.scale*16*sizeMultiplier);
        hitBoxDefaultX=hitBox.x;
        hitBoxDefaultY=hitBox.y;

        getImage();
    }
    public void getImage(){

        up1=setup("/entities/mob/Slime/Sprite/Slime.png");
        up2=setup("/entities/mob/Slime/Sprite/Slime 2.png");
        up3=setup("/entities/mob/Slime/Sprite/Slime 3.png");
        up4=setup("/entities/mob/Slime/Sprite/Slime 4.png");
        down1=setup("/entities/mob/Slime/Sprite/Slime 1.png");
        down2=setup("/entities/mob/Slime/Sprite/Slime 2.png");
        down3=setup("/entities/mob/Slime/Sprite/Slime 3.png");
        down4=setup("/entities/mob/Slime/Sprite/Slime 4.png");
        left1=setup("/entities/mob/Slime/Sprite/Slime 1.png");
        left2=setup("/entities/mob/Slime/Sprite/Slime 2.png");
        left3=setup("/entities/mob/Slime/Sprite/Slime 3.png");
        left4=setup("/entities/mob/Slime/Sprite/Slime 4.png");
        right1=setup("/entities/mob/Slime/Sprite/Slime 1.png");
        right2=setup("/entities/mob/Slime/Sprite/Slime 2.png");
        right3=setup("/entities/mob/Slime/Sprite/Slime 3.png");
        right4=setup("/entities/mob/Slime/Sprite/Slime 4.png");
        hitDown1=setup("/entities/mob/Slime/Sprite/Slime attack 9.png");
        hitDown2=setup("/entities/mob/Slime/Sprite/Slime attack 10.png");
        hitUp1=setup("/entities/mob/Slime/Sprite/Slime attack 7.png");
        hitUp2=setup("/entities/mob/Slime/Sprite/Slime attack 8.png");
        hitLeft1=setup("/entities/mob/Slime/Sprite/Slime attack 3.png");
        hitLeft2=setup("/entities/mob/Slime/Sprite/Slime attack 4.png");
        hitRight1=setup("/entities/mob/Slime/Sprite/Slime attack 5.png");
        hitRight2=setup("/entities/mob/Slime/Sprite/Slime attack 6.png");


    }public void setAction(){
        Random random= new Random();
        int i = random.nextInt(4);
        if (i==0){
            direction="up";
            speed=0;

        }if (i==1){
            direction="down";
            speed=0;

        }if (i==2){
            direction="left";
            speed=0;

        }if (i==3){
            direction="right";
            speed=0;

        }

    }
}
