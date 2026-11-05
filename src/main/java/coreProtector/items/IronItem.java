package coreProtector.items;

import coreProtector.gameGestion.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class IronItem extends SuperItem{

    GamePanel gp;

    public IronItem(GamePanel gp){

        this.gp=gp;
        name="iron";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/items/iron_item.png"));
            uTool.scaledImage(image,gp.tileSize ,gp.tileSize );
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
