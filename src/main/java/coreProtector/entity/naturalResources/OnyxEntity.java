package coreProtector.entity.naturalResources;

import coreProtector.entity.Entity;
import coreProtector.gameGestion.GamePanel;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;
import java.awt.*;
import java.util.Random;
public class OnyxEntity extends Entity{
    public OnyxEntity(GamePanel gp) {
        super(gp);

        name= "onyx";
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

        up1=setup("/entities/ressource/onyx_ore");
        up2=setup("/entities/ressource/onyx_ore");
        up3=setup("/entities/ressource/onyx_ore");
        up4=setup("/entities/ressource/onyx_ore");




    }public void setAction(){
        direction="up";
        speed=0;


    }
}
