package coreProtector.items;

import javax.imageio.ImageIO;
import java.io.IOException;

public class TesItem extends  SuperItem{

    public  TesItem(){
        name="test";

        try {

            image = ImageIO.read(getClass().getResourceAsStream("/items/p1.png"));
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
