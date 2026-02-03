package coreProtector.gameGestion;

import coreProtector.items.GoldCoin;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp=gp;
    }

    public void setItem(){
        gp.itm[0]=new GoldCoin();
        gp.itm[0].worldX= 20 * gp.tileSize;
        gp.itm[0].worldY=20 * gp.tileSize;



    }
}
