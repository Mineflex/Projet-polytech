package coreProtector.userInterface;

import coreProtector.entity.Player;
import coreProtector.gameGestion.GamePanel;
import coreProtector.items.GoldCoin;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {
    GamePanel gp;
    Font arial_50;
    BufferedImage image=null;

    public UI(GamePanel gp){

        this.gp=gp;
        arial_50=new Font("Arial",Font.PLAIN,50);
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/UI/gold_coinUI.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void draw(Graphics2D g2){

        g2.setFont(arial_50);
        g2.setColor(Color.white);
        g2.drawString(" x"+gp.player.goldCoin, 100,100);
        g2.drawImage(image,10,10,gp.tileSize,gp.tileSize,null);

    }
}
