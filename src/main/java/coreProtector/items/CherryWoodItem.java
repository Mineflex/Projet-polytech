package coreProtector.items;

import coreProtector.gameGestion.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class CherryWoodItem extends SuperItem{

    GamePanel gp;

    public CherryWoodItem(GamePanel gp){

        this.gp=gp;
        name="CherryWoodItem";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/items/cherry_wood_item.png"));
            uTool.scaledImage(image,gp.tileSize ,gp.tileSize );
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}

