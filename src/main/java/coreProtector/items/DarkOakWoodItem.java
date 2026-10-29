package coreProtector.items;
import coreProtector.gameGestion.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
public class DarkOakWoodItem extends SuperItem{

    GamePanel gp;

    public DarkOakWoodItem(GamePanel gp){

        this.gp=gp;
        name="DarkOakWoodItem";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/items/darkoak_wood_item.png"));
            uTool.scaledImage(image,gp.tileSize ,gp.tileSize );
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
