package coreProtector.entity.defenses;

import coreProtector.entity.Entity;
import coreProtector.gameGestion.GamePanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class StoneWall extends Entity {



    GamePanel gp;
    public StoneWall(GamePanel gp) {
        super(gp);



        name= "StoneWall";
        speed =0;
        maxLife=30;
        life=maxLife;
        this.gp=gp;
        sizeMultiplier=1;
        hitBox=new Rectangle(0 + gp.scale *8*sizeMultiplier,0 + gp.scale *8*sizeMultiplier ,gp.scale*16*sizeMultiplier,gp.scale*16*sizeMultiplier);
        hitBoxDefaultY=hitBox.y;
        level=2;
        maxLevel=2;

        upCost = new ArrayList<>(
                Arrays.asList(
                        1000000000, //gold
                        0 , //oak
                        0, //birch
                        0 , //dark
                        0 , //cherry
                        0 , //brazier
                        0 ,//charged wood
                        0, //rock
                        0,//iron
                        0,//titane
                        0, //rubis
                        0 // onyx
                )
        );


        getImage();
    }
    public void getImage(){

        up1=setup("/defense/wall/stone_wall_2");
        up2=setup("/defense/wall/stone_wall_2");
        up3=setup("/defense/wall/stone_wall_2");
        up4=setup("/defense/wall/stone_wall_2");
        down1=setup("/defense/wall/stone_wall_1");
        down2=setup("/defense/wall/stone_wall_1");
        down3=setup("/defense/wall/stone_wall_1");
        down4=setup("/defense/wall/stone_wall_1");
        left1=setup("/defense/wall/stone_wall_0");
        left2=setup("/defense/wall/stone_wall_0");
        left3=setup("/defense/wall/stone_wall_0");
        left4=setup("/defense/wall/stone_wall_0");
        right1=setup("/defense/wall/stone_wall_0");
        right2=setup("/defense/wall/stone_wall_0");
        right3=setup("/defense/wall/stone_wall_0");
        right4=setup("/defense/wall/stone_wall_0");





    }public void setAction(){


    }


}
