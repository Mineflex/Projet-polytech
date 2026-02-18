package coreProtector.userInterface;

import coreProtector.entity.Player;
import coreProtector.gameGestion.GamePanel;
import coreProtector.items.GoldCoin;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class UI {
    GamePanel gp;
    Font arial_20;
    BufferedImage image=null;
    public String uiPanel = "basic";

    public UI(GamePanel gp){

        this.gp=gp;
        arial_20=new Font("Arial",Font.PLAIN,20);
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/UI/gold_coinUI.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void BasicUI(Graphics2D g2){
        g2.setFont(arial_20);
        g2.setColor(Color.white);
        g2.drawString(" x"+gp.player.goldCoin, 675,130);
        g2.drawImage(image,150+500,107,36,36,null);

        if (gp.player.canViewHealthBar){
            g2.setColor(Color.black);
            g2.drawRoundRect( 130, 75 , 750,35,20,20);
            g2.setColor(Color.red);
            g2.fillRoundRect(130 ,76,749-gp.player.goldCoin,34,20,20);
        }
        g2.setColor(Color.black);
        g2.drawRoundRect(130, 115, 500, 15, 10, 10);
        g2.setColor(new Color(0, 100, 0));
        g2.fillRoundRect(130, 116, 500, 14, 10, 10);


    }

    public void CompetenceUI(Graphics2D g2){
        g2.setColor(Color.black);
        g2.drawRoundRect(5,5,gp.screenWidth-20,gp.screenHeight-10,10,20);
        g2.setColor(new Color(138, 92, 7, 247));
        g2.fillRoundRect(6, 6, gp.screenWidth-21, gp.screenHeight-11, 20, 20);


    }

    public void draw(Graphics2D g2){
        if (uiPanel == "basic"){
            BasicUI(g2);
        } if (uiPanel == "competence"){
            CompetenceUI(g2);
        }

    }
}
