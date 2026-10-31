package coreProtector.gameGestion;

import coreProtector.entity.defenses.Canon;
import coreProtector.entity.mobs.Goblin;
import coreProtector.entity.mobs.Slime;
import coreProtector.entity.naturalResources.*;
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
        gp.itm[1].stack=20000;

        gp.itm[2]=new ExperienceOrb(gp);
        gp.itm[2].worldX= 120 * gp.tileSize;
        gp.itm[2].worldY=115 * gp.tileSize;
        gp.itm[2].stack=1000000000;



    }
    public void setMonster(){

        gp.monster[0]= new Goblin(gp);
        gp.monster[0].worldx=115*gp.tileSize;
        gp.monster[0].worldy=125*gp.tileSize;



        gp.monster[1]= new Slime(gp);
        gp.monster[1].worldx=116*gp.tileSize;
        gp.monster[1].worldy=125*gp.tileSize;

        gp.monster[2]= new DarkOakWoodEntity(gp);
        gp.monster[2].worldx=110*gp.tileSize;
        gp.monster[2].worldy=115*gp.tileSize;

        gp.monster[3]= new CherryWoodEntity(gp);
        gp.monster[3].worldx=115*gp.tileSize;
        gp.monster[3].worldy=110*gp.tileSize;

        gp.monster[4]= new BlazingWoodEntity(gp);
        gp.monster[4].worldx=110*gp.tileSize;
        gp.monster[4].worldy=110*gp.tileSize;

        gp.monster[5]= new Goblin(gp);
        gp.monster[5].worldx=117*gp.tileSize;
        gp.monster[5].worldy=125*gp.tileSize;

        gp.monster[6]= new Goblin(gp);
        gp.monster[6].worldx=118*gp.tileSize;
        gp.monster[6].worldy=125*gp.tileSize;

        gp.monster[7]= new OakWoodEntity(gp);
        gp.monster[7].worldx=116*gp.tileSize;
        gp.monster[7].worldy=130*gp.tileSize;

        gp.monster[8]= new StoneEntity(gp);
        gp.monster[8].worldx=110*gp.tileSize;
        gp.monster[8].worldy=130*gp.tileSize;

        gp.monster[9]= new IronEntity(gp);
        gp.monster[9].worldx=112*gp.tileSize;
        gp.monster[9].worldy=130*gp.tileSize;

        gp.monster[10]= new OnyxEntity(gp);
        gp.monster[10].worldx=114*gp.tileSize;
        gp.monster[10].worldy=130*gp.tileSize;

    }

    public  void  setDefense(){
        gp.defense[0]= new Canon(gp);
        gp.defense[0].worldx=15*gp.tileSize;
        gp.defense[0].worldy=15*gp.tileSize;

    }
}
