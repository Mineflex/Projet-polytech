package coreProtector.gameGestion;

import coreProtector.entity.defenses.Canon;
import coreProtector.entity.mobs.Goblin;
import coreProtector.entity.naturalResources.OakWoodEntity;
import coreProtector.items.ExperienceOrb;
import coreProtector.items.GoldCoin;
import coreProtector.items.OakWoodItem;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp=gp;
    }

    public void setItem(){
        gp.itm[0]=new ExperienceOrb(gp);
        gp.itm[0].worldX= 120 * gp.tileSize;
        gp.itm[0].worldY=120 * gp.tileSize;
        gp.itm[0].stack=100;


        gp.itm[1]=new ExperienceOrb(gp);
        gp.itm[1].worldX= 115 * gp.tileSize;
        gp.itm[1].worldY=120 * gp.tileSize;
        gp.itm[1].stack=100;

        gp.itm[2]=new ExperienceOrb(gp);
        gp.itm[2].worldX= 120 * gp.tileSize;
        gp.itm[2].worldY=115 * gp.tileSize;
        gp.itm[2].stack=1000000000;



    }
    public void setMonster(){

        gp.monster[0]= new Goblin(gp);
        gp.monster[0].worldx=115*gp.tileSize;
        gp.monster[0].worldy=125*gp.tileSize;
        gp.monster[1]= new OakWoodEntity(gp);
        gp.monster[1].worldx=115*gp.tileSize;
        gp.monster[1].worldy=115*gp.tileSize;





    }

    public  void  setDefense(){
        gp.defense[0]= new Canon(gp);
        gp.defense[0].worldx=15*gp.tileSize;
        gp.defense[0].worldy=15*gp.tileSize;

    }
}
