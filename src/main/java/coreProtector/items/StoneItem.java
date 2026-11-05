package coreProtector.items;

import coreProtector.gameGestion.GamePanel;
import coreProtector.items.SuperItem;

import javax.imageio.ImageIO;
import java.io.IOException;

public class StoneItem extends SuperItem {

    GamePanel gp;

    public StoneItem(GamePanel gp){

        this.gp=gp;
        name="stone";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/items/stone_item.png"));
            uTool.scaledImage(image,gp.tileSize ,gp.tileSize );
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
