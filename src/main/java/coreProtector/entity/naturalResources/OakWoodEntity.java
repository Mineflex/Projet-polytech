package coreProtector.entity.naturalResources;

import coreProtector.entity.Entity;
import coreProtector.gameGestion.GamePanel;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;
import java.awt.*;
import java.util.Random;


public class OakWoodEntity extends Entity {

    public OakWoodEntity(GamePanel gp) {
        super(gp);

        name= "Oak Wood";
        speed =1;
        maxLife=3;
        life=maxLife;
        sizeMultiplier=2;

        hitBox=new Rectangle(0 + gp.scale *8*sizeMultiplier,0 + gp.scale *8*sizeMultiplier ,gp.scale*16*sizeMultiplier,gp.scale*16*sizeMultiplier);
        hitBoxDefaultX=hitBox.x;
        hitBoxDefaultY=hitBox.y;

        getImage();
    }
    public void getImage(){

        up1=setup("/entities/ressource/tree_1");
        up2=setup("/entities/ressource/tree_1");
        up3=setup("/entities/ressource/tree_1");
        up4=setup("/entities/ressource/tree_1");




    }public void setAction(){
        direction="up";
        speed=0;


    }

}
