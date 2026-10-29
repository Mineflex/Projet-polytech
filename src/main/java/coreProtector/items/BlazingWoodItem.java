package coreProtector.items;

import coreProtector.gameGestion.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class BlazingWoodItem extends SuperItem{

    GamePanel gp;

    public BlazingWoodItem(GamePanel gp){

        this.gp=gp;
        name="blazingWoodItem";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/items/blazing_wood_item.png"));
            uTool.scaledImage(image,gp.tileSize ,gp.tileSize );
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
