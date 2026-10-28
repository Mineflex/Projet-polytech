package coreProtector.entity.defenses;

import coreProtector.entity.Entity;
import coreProtector.gameGestion.GamePanel;

import java.awt.*;
import java.util.Random;

public class Canon extends Entity {





    public Canon(GamePanel gp) {
        super(gp);

        name= "Canon";
        speed =0;
        maxLife=5;
        life=maxLife;
        int defenseLevel=1;

        hitBox=new Rectangle(0 + gp.scale *8*sizeMultiplier,0 + gp.scale *8*sizeMultiplier ,gp.scale*16*sizeMultiplier,gp.scale*16*sizeMultiplier);
        hitBoxDefaultY=hitBox.y;

        getImage();
    }
    public void getImage(){

        up1=setup("/defense/canon/lvl1_canon_sprite08");
        up2=setup("/defense/canon/lvl1_canon_sprite09");
        up3=setup("/defense/canon/lvl1_canon_sprite10");
        up4=setup("/defense/canon/lvl1_canon_sprite11");
        down1=setup("/defense/canon/lvl1_canon_sprite12");
        down2=setup("/defense/canon/lvl1_canon_sprite13");
        down3=setup("/defense/canon/lvl1_canon_sprite14");
        down4=setup("/defense/canon/lvl1_canon_sprite15");
        left1=setup("/defense/canon/lvl1_canon_sprite04");
        left2=setup("/defense/canon/lvl1_canon_sprite05");
        left3=setup("/defense/canon/lvl1_canon_sprite06");
        left4=setup("/defense/canon/lvl1_canon_sprite07");
        right1=setup("/defense/canon/lvl1_canon_sprite00");
        right2=setup("/defense/canon/lvl1_canon_sprite01");
        right3=setup("/defense/canon/lvl1_canon_sprite02");
        right4=setup("/defense/canon/lvl1_canon_sprite03");
        hitDown1=setup("/playerSprites/player_sprite16");
        hitDown2=setup("/playerSprites/player_sprite17");
        hitUp1=setup("/playerSprites/player_sprite18");
        hitUp2=setup("/playerSprites/player_sprite19");
        hitLeft1=setup("/playerSprites/player_sprite20");
        hitLeft2=setup("/playerSprites/player_sprite21");
        hitRight1=setup("/playerSprites/player_sprite22");
        hitRight2=setup("/playerSprites/player_sprite23");




    }public void setAction(){


    }


}
