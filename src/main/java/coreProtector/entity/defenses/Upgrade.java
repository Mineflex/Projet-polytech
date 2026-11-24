package coreProtector.entity.defenses;

import coreProtector.entity.Entity;
import coreProtector.gameGestion.GamePanel;

import java.awt.*;

public class Upgrade extends Entity {



    GamePanel gp;
    public Upgrade(GamePanel gp) {
        super(gp);



        name= "Upgrade";
        this.gp=gp;



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
