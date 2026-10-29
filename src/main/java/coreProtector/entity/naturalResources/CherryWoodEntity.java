package coreProtector.entity.naturalResources;

import coreProtector.entity.Entity;
import coreProtector.gameGestion.GamePanel;

import java.awt.*;


public class CherryWoodEntity extends Entity {

    public CherryWoodEntity(GamePanel gp) {
        super(gp);

        name= "Cherry Wood";
        speed =1;
        maxLife=30;
        life=maxLife;
        sizeMultiplier=2;

        hitBox=new Rectangle(0 + gp.scale *8*sizeMultiplier,0 + gp.scale *8*sizeMultiplier ,gp.scale*16*sizeMultiplier,gp.scale*16*sizeMultiplier);
        hitBoxDefaultX=hitBox.x;
        hitBoxDefaultY=hitBox.y;

        getImage();
    }
    public void getImage(){

        up1=setup("/entities/ressource/cherry_tree");
        up2=setup("/entities/ressource/cherry_tree");
        up3=setup("/entities/ressource/cherry_tree");
        up4=setup("/entities/ressource/cherry_tree");




    }public void setAction(){
        direction="up";
        speed=0;


    }

}
