package coreProtector.gameGestion;

import coreProtector.entity.mobs.Goblin;
import coreProtector.items.ExperienceOrb;
import coreProtector.items.GoldCoin;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp=gp;
    }

    public void setItem(){
        gp.itm[0]=new ExperienceOrb(gp);
        gp.itm[0].worldX= 20 * gp.tileSize;
        gp.itm[0].worldY=20 * gp.tileSize;
        gp.itm[0].stack=100;


        gp.itm[1]=new ExperienceOrb(gp);
        gp.itm[1].worldX= 15 * gp.tileSize;
        gp.itm[1].worldY=20 * gp.tileSize;
        gp.itm[1].stack=100;

        gp.itm[2]=new ExperienceOrb(gp);
        gp.itm[2].worldX= 20 * gp.tileSize;
        gp.itm[2].worldY=15 * gp.tileSize;
        gp.itm[2].stack=1000000000;



    }
    public void setMonster(){
        /*gp.monster[0]= new Goblin(gp);
        gp.monster[0].worldx=20*gp.tileSize;
        gp.monster[0].worldy=25*gp.tileSize;*/
    }
}
