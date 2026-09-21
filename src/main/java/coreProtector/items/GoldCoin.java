package coreProtector.items;

import coreProtector.gameGestion.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class GoldCoin extends SuperItem{

    GamePanel gp;

    public GoldCoin(GamePanel gp){

        this.gp=gp;
        name="Block";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/items/gold_coin.png"));
            uTool.scaledImage(image,gp.tileSize,gp.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
