package coreProtector.userInterface;

import coreProtector.entity.Player;
import coreProtector.gameGestion.GamePanel;

import java.awt.*;

public class UI {
    GamePanel gp;
    Font arial_50;


    public UI(GamePanel gp){


        arial_50=new Font("Arial",Font.PLAIN,50);
    }
    public void draw(Graphics2D g2){
        g2.setFont(arial_50);
        g2.setColor(Color.white);
        g2.drawString("Jour :", 50,50);
    }
}
