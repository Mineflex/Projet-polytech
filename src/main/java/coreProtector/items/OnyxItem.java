package coreProtector.items;

import coreProtector.gameGestion.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OnyxItem extends SuperItem{

    GamePanel gp;

    public OnyxItem(GamePanel gp){

        this.gp=gp;
        name="onyx";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/items/onyx_item.png"));
            uTool.scaledImage(image,gp.tileSize ,gp.tileSize );
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
