package coreProtector.entity.naturalResources;

import coreProtector.entity.Entity;
import coreProtector.gameGestion.GamePanel;

import java.awt.*;


public class BlazingWoodEntity extends Entity {

    public BlazingWoodEntity(GamePanel gp) {
        super(gp);

        name= "Blazing Wood";
        speed =1;
        maxLife=40;
        life=maxLife;
        sizeMultiplier=2;

        hitBox=new Rectangle(0 + gp.scale *8*sizeMultiplier,0 + gp.scale *8*sizeMultiplier ,gp.scale*16*sizeMultiplier,gp.scale*16*sizeMultiplier);
        hitBoxDefaultX=hitBox.x;
        hitBoxDefaultY=hitBox.y;

        getImage();
    }
    public void getImage(){

        up1=setup("/entities/ressource/flame_tree");
        up2=setup("/entities/ressource/flame_tree");
        up3=setup("/entities/ressource/flame_tree");
        up4=setup("/entities/ressource/flame_tree");




    }public void setAction(){
        direction="up";
        speed=0;


    }

}
