package coreProtector.entity.naturalResources;

import coreProtector.entity.Entity;
import coreProtector.gameGestion.GamePanel;

import java.awt.*;


public class DarkOakWoodEntity extends Entity {

    public DarkOakWoodEntity(GamePanel gp) {
        super(gp);

        name= "Dark Oak Wood";
        speed =1;
        maxLife=15;
        life=maxLife;
        sizeMultiplier=2;

        hitBox=new Rectangle(0 + gp.scale *8*sizeMultiplier,0 + gp.scale *8*sizeMultiplier ,gp.scale*16*sizeMultiplier,gp.scale*16*sizeMultiplier);
        hitBoxDefaultX=hitBox.x;
        hitBoxDefaultY=hitBox.y;

        getImage();
    }
    public void getImage(){

        up1=setup("/entities/ressource/dark_tree");
        up2=setup("/entities/ressource/dark_tree");
        up3=setup("/entities/ressource/dark_tree");
        up4=setup("/entities/ressource/dark_tree");




    }public void setAction(){
        direction="up";
        speed=0;


    }

}
