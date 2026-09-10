package coreProtector.items;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ExperienceOrb extends SuperItem{


    public ExperienceOrb(){

        name="ExperienceOrb";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/items/xp_orb.png"));
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
