package coreProtector.entity.naturalResources;

import coreProtector.entity.Entity;
import coreProtector.gameGestion.GamePanel;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;
import java.awt.*;
import java.util.Random;
public class StoneEntity extends Entity{
    public StoneEntity(GamePanel gp) {
        super(gp);

        name= "Stone";
        speed =1;
        maxLife=6;
        life=maxLife;
        sizeMultiplier=1;

        hitBox=new Rectangle(0 + gp.scale *8*sizeMultiplier,0 + gp.scale *8*sizeMultiplier ,gp.scale*16*sizeMultiplier,gp.scale*16*sizeMultiplier);
        hitBoxDefaultX=hitBox.x;
        hitBoxDefaultY=hitBox.y;

        getImage();
    }
    public void getImage(){

        up1=setup("/entities/ressource/stone_ore");
        up2=setup("/entities/ressource/stone_ore");
        up3=setup("/entities/ressource/stone_ore");
        up4=setup("/entities/ressource/stone_ore");




    }public void setAction(){
        direction="up";
        speed=0;


    }
}
