package coreProtector.entity.defenses;

import coreProtector.entity.Entity;
import coreProtector.entity.projectiles.CanonBall;
import coreProtector.gameGestion.GamePanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class WoodWall extends Entity {



    GamePanel gp;
    public WoodWall(GamePanel gp) {
        super(gp);



        name= "WoodWall";
        speed =0;
        maxLife=10;
        life=maxLife;
        int defenseLevel=1;
        this.gp=gp;
        sizeMultiplier=1;
        hitBox=new Rectangle(0 + gp.scale *8*sizeMultiplier,0 + gp.scale *8*sizeMultiplier ,gp.scale*16*sizeMultiplier,gp.scale*16*sizeMultiplier);
        hitBoxDefaultY=hitBox.y;
        level=1;
        maxLevel=2;

        nextLevel = new StoneWall(gp);
        upCost = new ArrayList<>(
                Arrays.asList(
                        3, //gold
                        5 , //oak
                        0, //birch
                        0 , //dark
                        0 , //cherry
                        0 , //brazier
                        0 ,//charged wood
                        15, //rock
                        0,//iron
                        0,//titane
                        0, //rubis
                        0 // onyx
                )
        );


        getImage();
    }
    public void getImage(){

        up1=setup("/defense/wall/wood_wall_0");
        up2=setup("/defense/wall/wood_wall_0");
        up3=setup("/defense/wall/wood_wall_0");
        up4=setup("/defense/wall/wood_wall_0");
        down1=setup("/defense/wall/wood_wall_0");
        down2=setup("/defense/wall/wood_wall_0");
        down3=setup("/defense/wall/wood_wall_0");
        down4=setup("/defense/wall/wood_wall_0");
        left1=setup("/defense/wall/wood_wall_0");
        left2=setup("/defense/wall/wood_wall_0");
        left3=setup("/defense/wall/wood_wall_0");
        left4=setup("/defense/wall/wood_wall_0");
        right1=setup("/defense/wall/wood_wall_0");
        right2=setup("/defense/wall/wood_wall_0");
        right3=setup("/defense/wall/wood_wall_0");
        right4=setup("/defense/wall/wood_wall_0");





    }public void setAction(){


    }


}
