package coreProtector.entity.naturalResources;

import coreProtector.entity.Entity;
import coreProtector.gameGestion.GamePanel;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;
import java.awt.*;
import java.util.Random;
public class IronEntity extends Entity{
    public IronEntity(GamePanel gp) {
        super(gp);

        name= "Iron";
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

        up1=setup("/entities/ressource/iron_ore");
        up2=setup("/entities/ressource/iron_ore");
        up3=setup("/entities/ressource/iron_ore");
        up4=setup("/entities/ressource/iron_ore");




    }public void setAction(){
        direction="up";
        speed=0;


    }
}
