package coreProtector.userInterface;

import coreProtector.entity.Player;
import coreProtector.gameGestion.GamePanel;
import coreProtector.gameGestion.KeyHandler;
import coreProtector.items.GoldCoin;
import coreProtector.gameGestion.DayCycle;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class UI {
    GamePanel gp;
    Font arial_20;
    Font arial_28_Bold;
    BufferedImage image=null;
    KeyHandler keyH;
    public String uiPanel = "basic";
    public boolean showControl;
    public Rectangle btnSeeHealthBar;
    public Rectangle btnSpeedUpgrade;
    public Rectangle btnEnduranceUpgrade;
    private boolean mousePressed = false;
    public int alpha;

    public int controlMenuX=0;


    public UI(GamePanel gp){

        this.gp=gp;
        arial_20=new Font("Arial",Font.PLAIN,20);
        arial_28_Bold = new Font("Arial", Font.BOLD,28);

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/UI/gold_coinUI.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        btnSeeHealthBar = new Rectangle(50, 50, 200, 50); // x, y, largeur, hauteur
        btnSpeedUpgrade = new Rectangle(300, 50, 200, 50); // x, y, largeur, hauteur
        btnEnduranceUpgrade = new Rectangle(550, 50, 200, 50); // x, y, largeur, hauteur

    }
    public void BasicUI(Graphics2D g2){
        this.keyH=keyH;





        int totalMinutes = (gp.dayCycle.hour * 60) + gp.dayCycle.min;
        int alpha = 0;

        if (totalMinutes >= 18*60 || totalMinutes <= 6*60) {

            if (totalMinutes >= 21*60+30 && totalMinutes < 22*60) {
               alpha = (totalMinutes - (21*60+30)) * 180 / 30;
            }
            else if (totalMinutes >= 22*60 || totalMinutes < 5*60) {
                alpha = 190;
            }
            else if (totalMinutes >= 5*60 && totalMinutes < 6*60) {
                alpha = 190 - ((totalMinutes-5*60) * 190 / 60);
            }

        }


            g2.setColor(new Color(10, 10, 35, alpha));
            g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);



        g2.setColor(Color.white);
        g2.drawRect(1275, 20, 175, 25);
        g2.setColor(Color.gray);
        g2.fillRect(1275, 20, 175, 25);
        if (gp.dayCycle.hour>=22 || gp.dayCycle.hour<5){
            g2.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 20));
            g2.setColor(Color.white);

            g2.drawString(gp.dayCycle.realHour + ":" + gp.dayCycle.realMin + "-\uD83C\uDF19- DAY : " + gp.dayCycle.realDay, 1280, 40); // Heure et date

        }else {
            g2.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 20));
            g2.setColor(Color.white);

            g2.drawString(gp.dayCycle.realHour + ":" + gp.dayCycle.realMin + "-\u2600- DAY : " + gp.dayCycle.realDay, 1280, 40); // Heure et date

        }

        g2.setColor(Color.white);
        g2.drawRect(1330, 46, 120, 25);
        g2.setColor(Color.gray);
        g2.fillRect(1330, 46, 120, 25);

        g2.setFont(arial_20);
        g2.setColor(Color.white);
        g2.drawString(" X: "+(gp.player.worldx /gp.tileSize -gp.maxWorldCol/2) + " ; Y: " +(-gp.player.worldy /gp.tileSize +gp.maxWorldRow/2), 1330,66);

        if (gp.player.canViewHealthBar){
            g2.setColor(Color.black);
            g2.drawRoundRect( 80, 35 , 500,50,20,20);
            g2.setColor(Color.red);
            g2.fillRoundRect(80 ,36,499-gp.player.goldCoin,49,20,20);
        }
        g2.setColor(Color.black);
        g2.drawRoundRect(100, 85, 300, 20, 10, 10);
        g2.setColor(new Color(0, 100, 0));
        g2.fillRoundRect(100, 86, (int) (300*gp.playerXP.playerExPo/gp.playerXP.nextLevel), 19, 10, 10);

        g2.setFont(arial_20);
        g2.setColor(Color.white);
        g2.drawString("LVL: "+ gp.playerXP.playerLevel, 120, 102 );

        g2.setColor(Color.black);
        g2.drawOval(20, 20, 100, 100);
        g2.setColor(Color.blue);
        g2.fillOval(20, 20, 100, 100 );

        g2.setFont(arial_20);
        g2.setColor(Color.white);
        g2.drawString("Core", 50, 75);



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
        g2.setColor(new Color(138, 92, 7, 255));
        g2.fillRoundRect(6, 6, gp.screenWidth-21, gp.screenHeight-11, 20, 20);
        g2.setColor(Color.WHITE);
        g2.draw(btnSeeHealthBar);
        g2.setFont(arial_20);
        g2.setColor(Color.white);
        g2.drawString("Point disponible: " + gp.playerXP.cPAvailable,  80, 750);
        g2.setColor(Color.WHITE);
        g2.draw(btnSpeedUpgrade);
        g2.setColor(Color.WHITE);
        g2.draw(btnEnduranceUpgrade);

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
        if (gp.player.maxEndurance<8){
            g2.setFont(arial_20);
            g2.drawString("Augmente l'endurance MAX ( "+Math.round((gp.player.maxEndurance)-4)+"/4 )", btnEnduranceUpgrade.x + 20, btnEnduranceUpgrade.y + 32);
        }else {

            g2.setColor(new Color(97, 64, 4, 247));

            g2.fillRect(btnEnduranceUpgrade.x, btnEnduranceUpgrade.y, 200, 50);
            g2.setFont(arial_20);
            g2.setColor(Color.white);
            g2.drawString("Debloqué !", btnEnduranceUpgrade.x + 40, btnEnduranceUpgrade.y + 32);
        }



    }

    public void ControllUI(Graphics2D g2){
        g2.setColor(new Color(97, 64, 4, 169));

        g2.fillRect(controlMenuX+ gp.screenWidth-400, 20, 380, gp.screenHeight-40);
        g2.setColor(Color.white);
        g2.setFont(arial_28_Bold);
        g2.drawString("Controls :", controlMenuX+ gp.screenWidth-350,  60);
        g2.drawString("Z/Q/S/D : Bouger",  controlMenuX+ gp.screenWidth-340,  110);
        g2.drawString("C : Competence", controlMenuX+ gp.screenWidth-340,  160);
        g2.drawString("Z/Q/S/D : Bouger",  controlMenuX+ gp.screenWidth-340,  210);
        g2.drawString("Espace : Taper",  controlMenuX+ gp.screenWidth-340,  260);
        g2.drawString("Tab : Ouvrir/Fermer",  controlMenuX+ gp.screenWidth-340,  310);



    }

    public void StatsUI(Graphics2D g2){
        g2.setColor(new Color(97, 64, 4, 168));

        g2.fillRect(15, 20, 380, gp.screenHeight-40);
        g2.setColor(Color.white);
        g2.setFont(arial_28_Bold);
        g2.drawString("Endurance :"+gp.player.maxEndurance, 65,  60);
        g2.drawString("Speed :"+gp.player.speedMultiplier,  65,  110);
        g2.drawString("Gold Fortune x"+ gp.player.goldFortune, 65,  160);
        g2.drawString("Ressources Fortune x"+gp.player.ressourcesFortune,  65,  210);
        g2.drawString("Core Health "+gp.player.health,  65,  260);

    }


    public void draw(Graphics2D g2){
        if (uiPanel == "basic"){
            BasicUI(g2);

        } if (uiPanel == "competence"){
            CompetenceUI(g2);
        }
        if (showControl==true){
            ControllUI(g2);
            StatsUI(g2);
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
                    if(btnEnduranceUpgrade.contains(mousePoint) && gp.player.maxEndurance<8){
                        gp.player.maxEndurance+=1;

                        gp.mouseH.mousePressed = false;
                        gp.playerXP.cPAvailable-=1;
                        gp.playerXP.cPUsed+=1;

                    }




                }
            }
        }
    }
}
