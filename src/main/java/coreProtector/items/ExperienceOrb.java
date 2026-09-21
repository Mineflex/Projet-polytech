package coreProtector.items;

import coreProtector.gameGestion.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ExperienceOrb extends SuperItem{

GamePanel gp;
    public ExperienceOrb(GamePanel gp){

        this.gp=gp;
        name="ExperienceOrb";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/items/xp_orb.png"));
            uTool.scaledImage(image,gp.tileSize,gp.tileSize);

        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
