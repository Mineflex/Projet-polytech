package coreProtector.items;

import javax.imageio.ImageIO;
import java.io.IOException;

public class GoldCoin extends SuperItem{


    public GoldCoin(){

        name="Block";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/items/gold_coin.png"));
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
