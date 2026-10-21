package coreProtector.items;

import coreProtector.gameGestion.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OakWoodItem extends SuperItem{

    GamePanel gp;

    public OakWoodItem(GamePanel gp){

        this.gp=gp;
        name="oakWoodItem";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/items/oak_wood_item.png"));
            uTool.scaledImage(image,gp.tileSize ,gp.tileSize );
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
