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

        up1=setup("/entities/mob/slime/sprite/slime_1_sprite_00");
        up2=setup("/entities/mob/slime/sprite/slime_1_sprite_01");
        up3=setup("/entities/mob/slime/sprite/slime_1_sprite_02");
        up4=setup("/entities/mob/slime/sprite/slime_1_sprite_03");
        down1=setup("/entities/mob/slime/sprite/slime_1_sprite_00");
        down2=setup("/entities/mob/slime/sprite/slime_1_sprite_01");
        down3=setup("/entities/mob/slime/sprite/slime_1_sprite_02");
        down4=setup("/entities/mob/slime/sprite/slime_1_sprite_03");
        left1=setup("/entities/mob/slime/sprite/slime_1_sprite_00");
        left2=setup("/entities/mob/slime/sprite/slime_1_sprite_01");
        left3=setup("/entities/mob/slime/sprite/slime_1_sprite_02");
        left4=setup("/entities/mob/slime/sprite/slime_1_sprite_03");
        right1=setup("/entities/mob/slime/sprite/slime_1_sprite_00");
        right2=setup("/entities/mob/slime/sprite/slime_1_sprite_01");
        right3=setup("/entities/mob/slime/sprite/slime_1_sprite_02");
        right4=setup("/entities/mob/slime/sprite/slime_1_sprite_03");
        hitDown1=setup("/entities/mob/slime/sprite/slime_1_sprite_attack_06");
        hitDown2=setup("/entities/mob/slime/sprite/slime_1_sprite_attack_07");
        hitUp1=setup("/entities/mob/slime/sprite/slime_1_sprite_attack_04");
        hitUp2=setup("/entities/mob/slime/sprite/slime_1_sprite_attack_05");
        hitLeft1=setup("/entities/mob/slime/sprite/slime_1_sprite_attack_02");
        hitLeft2=setup("/entities/mob/slime/sprite/slime_1_sprite_attack_03");
        hitRight1=setup("/entities/mob/slime/sprite/slime_1_sprite_attack_00");
        hitRight2=setup("/entities/mob/slime/sprite/slime_1_sprite_attack_01");


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
