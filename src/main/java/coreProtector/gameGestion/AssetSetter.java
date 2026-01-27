package coreProtector.gameGestion;

import coreProtector.items.TesItem;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp=gp;
    }

    public void SetItem(){
        gp.itm[0]= new TesItem();
        gp.itm[0].worldX =25 * gp.tileSize;
        gp.itm[0].worldY= 20* gp.tileSize;

        gp.itm[1]= new TesItem();
        gp.itm[1].worldX =30* gp.tileSize;
        gp.itm[1].worldY= 18* gp.tileSize;
    }
}
