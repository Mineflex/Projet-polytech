package coreProtector.entity.mobs;

import coreProtector.entity.Entity;
import coreProtector.gameGestion.GamePanel;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;
import java.awt.*;
import java.util.Random;

public class Goblin extends Entity {


    public Goblin(GamePanel gp) {
        super(gp);

        name= "Goblin Lvl1";
        speed =1;
        maxLife=5;
        life=maxLife;

        hitBox=new Rectangle(0 + gp.scale *8*sizeMultiplier,0 + gp.scale *8*sizeMultiplier ,gp.scale*16*sizeMultiplier,gp.scale*16*sizeMultiplier);
        hitBoxDefaultX=hitBox.x;
        hitBoxDefaultY=hitBox.y;

        getImage();
    }
    public void getImage(){

        up1=setup("/entities/mob/goblin/sprite/goblin_1_sprite_11");
        up2=setup("/entities/mob/goblin/sprite/goblin_1_sprite_12");
        up3=setup("/entities/mob/goblin/sprite/goblin_1_sprite_13");
        up4=setup("/entities/mob/goblin/sprite/goblin_1_sprite_14");
        down1=setup("/entities/mob/goblin/sprite/goblin_1_sprite_00");
        down2=setup("/entities/mob/goblin/sprite/goblin_1_sprite_01");
        down3=setup("/entities/mob/goblin/sprite/goblin_1_sprite_02");
        down4=setup("/entities/mob/goblin/sprite/goblin_1_sprite_03");
        left1=setup("/entities/mob/goblin/sprite/goblin_1_sprite_04");
        left2=setup("/entities/mob/goblin/sprite/goblin_1_sprite_05");
        left3=setup("/entities/mob/goblin/sprite/goblin_1_sprite_06");
        left4=setup("/entities/mob/goblin/sprite/goblin_1_sprite_05");
        right1=setup("/entities/mob/goblin/sprite/goblin_1_sprite_07");
        right2=setup("/entities/mob/goblin/sprite/goblin_1_sprite_08");
        right3=setup("/entities/mob/goblin/sprite/goblin_1_sprite_09");
        right4=setup("/entities/mob/goblin/sprite/goblin_1_sprite_10");
        hitDown1=setup("/playerSprites/player_sprite16");
        hitDown2=setup("/playerSprites/player_sprite17");
        hitUp1=setup("/playerSprites/player_sprite18");
        hitUp2=setup("/playerSprites/player_sprite19");
        hitLeft1=setup("/playerSprites/player_sprite20");
        hitLeft2=setup("/playerSprites/player_sprite21");
        hitRight1=setup("/playerSprites/player_sprite22");
        hitRight2=setup("/playerSprites/player_sprite23");


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
