package coreProtector.entity.naturalResources;

import coreProtector.entity.Entity;
import coreProtector.gameGestion.GamePanel;

import java.awt.*;

public class Core extends Entity{
    public Core(GamePanel gp) {
        super(gp);

        name= "Core";
        speed =1;
        maxLife=6;
        life=maxLife;
        sizeMultiplier=5;

        hitBox=new Rectangle(0 ,0 ,0,0);
        hitBoxDefaultX=hitBox.x;
        hitBoxDefaultY=hitBox.y;

        getImage();
    }
    public void getImage(){

        up1=setup("/core/core");
        up2=setup("/core/core");
        up3=setup("/core/core");
        up4=setup("/core/core");




    }public void setAction(){
        direction="up";
        speed=0;


    }
}
