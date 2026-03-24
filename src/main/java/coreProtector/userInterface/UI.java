package coreProtector.userInterface;

import coreProtector.entity.Player;
import coreProtector.gameGestion.GamePanel;
import coreProtector.gameGestion.KeyHandler;
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
    KeyHandler keyH;
    public String uiPanel = "basic";

    public Rectangle btnSeeHealthBar;
    public Rectangle btnSpeedUpgrade;
    private boolean mousePressed = false;


    public UI(GamePanel gp){

        this.gp=gp;
        arial_20=new Font("Arial",Font.PLAIN,20);

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/UI/gold_coinUI.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        btnSeeHealthBar = new Rectangle(50, 50, 200, 50); // x, y, largeur, hauteur
        btnSpeedUpgrade = new Rectangle(300, 50, 200, 50); // x, y, largeur, hauteur

    }
    public void BasicUI(Graphics2D g2){
        this.keyH=keyH;
        g2.setFont(arial_20);
        g2.setColor(Color.white);
        g2.drawString(" x"+gp.player.goldCoin, 730,130);
        g2.drawImage(image,200+500,107,36,36,null);

        if (gp.player.canViewHealthBar){
            g2.setColor(Color.black);
            g2.drawRoundRect( 130, 75 , 750,35,20,20);
            g2.setColor(Color.red);
            g2.fillRoundRect(130 ,76,749-gp.player.goldCoin,34,20,20);
        }
        g2.setColor(Color.black);
        g2.drawRoundRect(130, 115, 500, 15, 10, 10);
        g2.setColor(new Color(0, 100, 0));
        g2.fillRoundRect(130, 116, (int) (500*gp.playerXP.playerExPo/gp.playerXP.nextLevel), 14, 10, 10);

        g2.setFont(arial_20);
        g2.setColor(Color.white);
        g2.drawString("Lvl: "+ gp.playerXP.playerLevel, 640, 130 );


        if (gp.player.maxEndurance >gp.player.endurance){

            if (gp.player.endurance > gp.player.maxEndurance* 3/4){
                g2.setColor(Color.black);
                g2.drawRoundRect( gp.screenWidth/2 -24,gp.screenHeight/2 -48, 50,5,2,2);
                g2.setColor(new Color(102, 255, 0, 219));
                g2.fillRoundRect(gp.screenWidth/2 -24,gp.screenHeight/2 -48, (gp.player.endurance *50)/gp.player.maxEndurance,5,2,2);

            } else if (gp.player.endurance > gp.player.maxEndurance/2) {
                g2.setColor(Color.black);
                g2.drawRoundRect( gp.screenWidth/2 -24,gp.screenHeight/2 -48, 50,5,2,2);
                g2.setColor(new Color(255, 115, 0, 219));
                g2.fillRoundRect(gp.screenWidth/2 -24,gp.screenHeight/2 -48, (gp.player.endurance *50)/gp.player.maxEndurance,5,2,2);


            }else  {
                g2.setColor(Color.black);
                g2.drawRoundRect( gp.screenWidth/2 -24,gp.screenHeight/2 -48, 50,5,2,2);
                g2.setColor(new Color(133, 0, 0, 219));
                g2.fillRoundRect(gp.screenWidth/2 -24,gp.screenHeight/2 -48, (gp.player.endurance *50)/gp.player.maxEndurance,5,2,2);

                }
        }
    }

    public void CompetenceUI(Graphics2D g2){
        g2.setColor(Color.black);
        g2.drawRoundRect(5,5,gp.screenWidth-20,gp.screenHeight-10,10,20);
        g2.setColor(new Color(138, 92, 7, 247));
        g2.fillRoundRect(6, 6, gp.screenWidth-21, gp.screenHeight-11, 20, 20);
        g2.setColor(Color.WHITE);
        g2.draw(btnSeeHealthBar);
        g2.setFont(arial_20);
        g2.setColor(Color.white);
        g2.drawString("Point disponible: " + gp.playerXP.cPAvailable,  80, 750);
        g2.setColor(Color.WHITE);
        g2.draw(btnSpeedUpgrade);

        if (gp.player.canViewHealthBar){


            g2.setColor(new Color(97, 64, 4, 247));

            g2.fillRect(50, 50, 200, 50);
            g2.setFont(arial_20);
            g2.setColor(Color.white);
            g2.drawString("Debloqué !", btnSeeHealthBar.x + 40, btnSeeHealthBar.y + 32);


        }else {
            g2.setFont(arial_20);
            g2.drawString("Voir la vie du Core", btnSeeHealthBar.x + 20, btnSeeHealthBar.y + 32);
        }
        if (gp.player.speedMultiplier<1.32){
            g2.setFont(arial_20);
            g2.drawString("Augmente la vitesse ( "+Math.round((gp.player.speedMultiplier -1)/0.08)+"/4 )", btnSpeedUpgrade.x + 20, btnSpeedUpgrade.y + 32);
        }else {

            g2.setColor(new Color(97, 64, 4, 247));

            g2.fillRect(btnSpeedUpgrade.x, btnSpeedUpgrade.y, 200, 50);
            g2.setFont(arial_20);
            g2.setColor(Color.white);
            g2.drawString("Debloqué !", btnSpeedUpgrade.x + 40, btnSpeedUpgrade.y + 32);
        }



    }

    public void draw(Graphics2D g2){
        if (uiPanel == "basic"){
            BasicUI(g2);
        } if (uiPanel == "competence"){
            CompetenceUI(g2);
        }

    }

    public void update() {
        if (uiPanel.equals("competence")) {
            if (gp.mouseH.mousePressed) {
                if (gp.playerXP.cPAvailable>0){
                    Point mousePoint = new Point(gp.mouseH.x, gp.mouseH.y);

                    if (btnSeeHealthBar.contains(mousePoint)) {


                            if (gp.player.canViewHealthBar==false) {
                                gp.mouseH.mousePressed = false;
                                gp.playerXP.cPAvailable-=1;
                                gp.playerXP.cPUsed+=1;
                            }
                        gp.player.canViewHealthBar=true;



                    }
                    if(btnSpeedUpgrade.contains(mousePoint) && gp.player.speedMultiplier<1.32){
                        gp.player.speedMultiplier+=0.08;

                         gp.mouseH.mousePressed = false;
                         gp.playerXP.cPAvailable-=1;
                         gp.playerXP.cPUsed+=1;

                    }



                }
            }
        }
    }
}
