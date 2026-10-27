package coreProtector.userInterface;
import coreProtector.entity.Entity;
import coreProtector.entity.Player;
import coreProtector.gameGestion.*;
import coreProtector.items.GoldCoin;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class UI {
    GamePanel gp;
    AssetSetter aSetter;
    DefenseManager dManager;
    Font arial_20;
    Font arial_28_Bold;
    Font arial_40_Bold;
    Font arial_80_Bold;
    KeyHandler keyH;
    public String uiPanel = "basic";
    public boolean isPlacingDef=false;
    public boolean showControl;
    public boolean uiInventory;
    public boolean uiGameover;
    public Rectangle btnSeeHealthBar;
    public Rectangle btnSpeedUpgrade;
    public Rectangle btnEnduranceUpgrade;
    public Rectangle btnRetry;


    BufferedImage goldCoin=null;
    BufferedImage oak=null;
    BufferedImage birch=null;
    BufferedImage darkOak=null;
    BufferedImage cherryWood=null;
    BufferedImage woodBrazier=null;
    BufferedImage chargedWood=null;
    BufferedImage rock=null;
    BufferedImage iron=null;
    BufferedImage titane=null;
    BufferedImage rubis=null;
    BufferedImage onyx=null;
    BufferedImage chargedRock=null;
    BufferedImage volcanicRock=null;
    BufferedImage sand=null;
    BufferedImage runeBrazier=null;
    BufferedImage chargedRune=null;
    BufferedImage physicalRune=null;

    BufferedImage logo=null;

    BufferedImage canon=null;
    BufferedImage flamethrower=null;
    BufferedImage electricTower=null;
    BufferedImage catapult=null;
    BufferedImage DEF5 = null;
    BufferedImage DEF6 = null;
    BufferedImage DEF7 = null;
    BufferedImage DEF8 = null;
    //il faudra changer les noms des défenses par celles qu on gardera



    public Rectangle btnCanon;
    public Rectangle btnFlameThrower;
    public Rectangle btnElectricTower;
    public Rectangle btnCatapult;
    public Rectangle btnDEF5;
    public Rectangle btnDEF6;
    public Rectangle btnDEF7;
    public Rectangle btnDEF8;





    private boolean mousePressed = false;
    public int alpha;

    public int controlMenuX=0;
    public String defType="";

    public UI(GamePanel gp){

        this.gp=gp;
        this.aSetter = new AssetSetter(gp);
        this.dManager=new DefenseManager(gp);
        arial_20=new Font("Arial",Font.PLAIN,20);
        arial_28_Bold = new Font("Arial", Font.BOLD,28);
        arial_40_Bold = new Font("Arial", Font.BOLD, 40 );
        arial_80_Bold = new Font("Arial", Font.BOLD, 80);

        try {
            goldCoin = ImageIO.read(getClass().getResourceAsStream("/UI/gold_coinUI.png"));
            oak = ImageIO.read(getClass().getResourceAsStream("/UI/oak_woodUI.png"));
            canon = ImageIO.read(getClass().getResourceAsStream("/defense/canon/lvl1_canon_sprite05.png"));
            //flamethrower =
            //electricTower =
            //catapult =
            // il faudra compléter cette partie du code quand les images du reste des défenses et ressources seront faites

            logo = ImageIO.read(getClass().getResourceAsStream("/UI/logo.png"));


        } catch (Exception e) {
            e.printStackTrace();
        }
        btnSeeHealthBar = new Rectangle(50, 50, 200, 50); // x, y, largeur, hauteur
        btnSpeedUpgrade = new Rectangle(300, 50, 200, 50); // x, y, largeur, hauteur
        btnEnduranceUpgrade = new Rectangle(550, 50, 200, 50); // x, y, largeur, hauteur
        btnRetry =new Rectangle(gp.screenWidth/2 - 100 ,465, 200, 50);

        btnCanon = new Rectangle(30, 460, canon.getWidth()*3, canon.getHeight()*3); // x, y, largeur, hauteur
        btnFlameThrower = new Rectangle(140, 460, canon.getWidth()*3, canon.getHeight()*3);
        btnElectricTower = new Rectangle(250, 460, canon.getWidth()*3, canon.getHeight()*3);
        btnCatapult = new Rectangle(360, 460, canon.getWidth()*3, canon.getHeight()*3);
        btnDEF5 = new Rectangle(30, 625, canon.getWidth()*3, canon.getHeight()*3);
        btnDEF6 = new Rectangle(140, 625, canon.getWidth()*3, canon.getHeight()*3);
        btnDEF7 = new Rectangle(250, 625, canon.getWidth()*3, canon.getHeight()*3);
        btnDEF8 = new Rectangle(360, 625, canon.getWidth()*3, canon.getHeight()*3);
        // il faudra changer les wight et height quand les sprites seront fait pour chaque défenses



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
        g2.drawRect(1295, 20, 215, 25);
        g2.setColor(Color.gray);
        g2.fillRect(1295, 20, 215, 25);

        if (gp.dayCycle.hour>=22 || gp.dayCycle.hour<5){
            g2.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 20));
            g2.setColor(Color.white);

            g2.drawString(gp.dayCycle.realHour + ":" + gp.dayCycle.realMin + "-\uD83C\uDF19- DAY : " + gp.dayCycle.realDay, 1300, 40); // Heure et date

        }else {
            g2.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 20));
            g2.setColor(Color.white);

            g2.drawString(gp.dayCycle.realHour + ":" + gp.dayCycle.realMin + "-\u2600- DAY : " + gp.dayCycle.realDay, 1300, 40); // Heure et date

        }

        g2.setColor(Color.white);
        g2.drawRect(1295, 46, 215, 25);
        g2.setColor(Color.gray);
        g2.fillRect(1295, 46, 215, 25);

        g2.setFont(arial_20);
        g2.setColor(Color.white);
        g2.drawString(" X: "+(gp.player.worldx /gp.tileSize -gp.maxWorldCol/2) + " ; Y: " +(-gp.player.worldy /gp.tileSize +gp.maxWorldRow/2), 1300,66);

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

        g2.setColor(Color.white);
        g2.setFont(arial_40_Bold);
        g2.drawString("Compétence", gp.screenWidth/2 - 120, 50);



        g2.setColor(Color.white);
        g2.drawRect(1295, 27, 200, 31);
        g2.setFont(arial_20);
        g2.setColor(Color.white);
        g2.drawString("Point disponible : " + gp.playerXP.cPAvailable,  1300, 50);


        g2.setColor(Color.WHITE);
        g2.draw(btnSeeHealthBar);

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


    public void InventaireUI(Graphics2D g2){


        //ressources
        g2.setColor(new Color(97, 64, 4, 169));
        g2.fillRoundRect(6, 6, gp.screenWidth/3 - 40, gp.screenHeight/2 - 9, 50, 50);
        g2.setFont(arial_28_Bold);
        g2.setColor(Color.white);
        g2.drawString("Ressources", 150 , 40);


        //gold
        g2.drawImage(goldCoin, 380, 15, goldCoin.getWidth() ,goldCoin.getHeight(),null);
        g2.setFont(arial_20);
        g2.setColor(Color.white);
        g2.drawString("×" + gp.player.goldCoin, goldCoin.getWidth() + 377, goldCoin.getHeight() + 7);

        //bois (il faudra finir cette partie une fois les sprites finis)
        g2.setColor(Color.white);
        g2.drawRoundRect(16,55, gp.screenWidth/3 - 60, 150, 50, 50);
        g2.setColor(new Color(97, 64, 4, 247));
        g2.fillRoundRect(16,55, gp.screenWidth/3 - 60, 150, 50, 50);

        g2.drawImage(oak, 25, 60, oak.getWidth() *2 ,oak.getHeight() *2,null);
        g2.setFont(arial_20);
        g2.setColor(Color.white);
        g2.drawString("×" + gp.player.oak, oak.getWidth()*2 + 20, oak.getHeight()*2 + 40);


        //minerais (il faudra finir cette partie une fois les sprites finis)
        g2.setColor(Color.white);
        g2.drawRoundRect(16,215, gp.screenWidth/3 - 60, 100, 50, 50);
        g2.setColor(new Color(97, 64, 4, 247));
        g2.fillRoundRect(16,215, gp.screenWidth/3 - 60, 100, 50, 50);


        //runes (il faudra finir cette partie une fois les sprites finis)
        g2.setColor(Color.white);
        g2.drawRoundRect(16,325, gp.screenWidth/3 - 60, 50, 50, 50);
        g2.setColor(new Color(97, 64, 4, 247));
        g2.fillRoundRect(16,325, gp.screenWidth/3 - 60, 50, 50, 50);






        //défences
        g2.setColor(new Color(97, 64, 4, 169));
        g2.fillRoundRect(6, gp.screenHeight/2 + 3, gp.screenWidth/3 - 40, gp.screenHeight/2 - 9, 50, 50);
        g2.setColor(Color.white);
        g2.setFont(arial_28_Bold);
        g2.drawString("Défenses", 180 , 420);


        //canon
        g2.setColor(Color.WHITE);
        g2.draw(btnCanon);
        g2.setColor(new Color(97, 64, 4, 247));
        g2.fillRect(btnCanon.x, btnCanon.y, btnCanon.width, btnCanon.height);
        g2.drawImage(canon, btnCanon.x + 3, btnCanon.y - 10, btnCanon.width , btnCanon.height, null);

        //lance flamme
        g2.setColor(Color.WHITE);
        g2.draw(btnFlameThrower);
        g2.setColor(new Color(97, 64, 4, 247));
        g2.fillRect(btnFlameThrower.x, btnFlameThrower.y, btnFlameThrower.width, btnFlameThrower.height);
        g2.drawImage(flamethrower, btnFlameThrower.x, btnFlameThrower.y, btnFlameThrower.width , btnFlameThrower.height, null);

        //tour électrique
        g2.setColor(Color.WHITE);
        g2.draw(btnElectricTower);
        g2.setColor(new Color(97, 64, 4, 247));
        g2.fillRect(btnElectricTower.x, btnElectricTower.y, btnElectricTower.width, btnElectricTower.height);
        g2.drawImage(electricTower, btnElectricTower.x, btnElectricTower.y, btnElectricTower.width , btnElectricTower.height, null);

        //catapulte
        g2.setColor(Color.WHITE);
        g2.draw(btnCatapult);
        g2.setColor(new Color(97, 64, 4, 247));
        g2.fillRect(btnCatapult.x, btnCatapult.y, btnCatapult.width, btnCatapult.height);
        g2.drawImage(catapult, btnCatapult.x, btnCatapult.y, btnCatapult.width , btnCatapult.height, null);

        //DEF5
        g2.setColor(Color.WHITE);
        g2.draw(btnDEF5);
        g2.setColor(new Color(97, 64, 4, 247));
        g2.fillRect(btnDEF5.x, btnDEF5.y, btnDEF5.width, btnDEF5.height);
        g2.drawImage(DEF5, btnDEF5.x, btnDEF5.y, btnDEF5.width , btnDEF5.height, null);

        //DEF6
        g2.setColor(Color.WHITE);
        g2.draw(btnDEF6);
        g2.setColor(new Color(97, 64, 4, 247));
        g2.fillRect(btnDEF6.x, btnDEF6.y, btnDEF6.width, btnDEF6.height);
        g2.drawImage(DEF6, btnDEF6.x, btnDEF6.y, btnDEF6.width , btnDEF6.height, null);

        //DEF7
        g2.setColor(Color.WHITE);
        g2.draw(btnDEF7);
        g2.setColor(new Color(97, 64, 4, 247));
        g2.fillRect(btnDEF7.x, btnDEF7.y, btnDEF7.width, btnDEF7.height);
        g2.drawImage(DEF7, btnDEF7.x, btnDEF7.y, btnDEF7.width , btnDEF7.height, null);

        //DEF8
        g2.setColor(Color.WHITE);
        g2.draw(btnDEF8);
        g2.setColor(new Color(97, 64, 4, 247));
        g2.fillRect(btnDEF8.x, btnDEF8.y, btnDEF8.width, btnDEF8.height);
        g2.drawImage(DEF8, btnDEF8.x, btnDEF8.y, btnDEF8.width , btnDEF8.height, null);





    }

    public void GameOverUI(Graphics2D g2){
        g2.setColor(new Color(0, 0, 0, 255));
        String gameOver = "Game Over";
        String Retry = "Retry";
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
        g2.setColor(new Color(0, 15, 55, 255));
        g2.fillRect(0, 25, gp.screenWidth, btnCanon.height*3);
        g2.setColor(Color.white);
        g2.setFont(arial_80_Bold);
        g2.drawString(gameOver, gp.screenWidth/2  - gameOver.length()*20 - 40 ,  200);
        g2.setColor(Color.WHITE);
        g2.draw(btnRetry);
        g2.setColor(new Color(250, 250, 250, 50));
        g2.fillRect(gp.screenWidth/2 - 100, 465, 200, 50);
        g2.setColor(Color.WHITE);
        g2.setFont(arial_28_Bold);
        g2.drawString(Retry, gp.screenWidth/2 -Retry.length()*7,  500);
        g2.drawImage(logo, 50, 50, btnCanon.height*3 ,btnCanon.height*3,null);
        g2.drawImage(logo, gp.screenWidth - btnCanon.height*3 - 50, 50, btnCanon.height*3 ,btnCanon.height*3,null);
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
        if (uiInventory == true){
            InventaireUI(g2);
        }
        if (uiGameover == true){
           GameOverUI(g2);
        }

    }

    public void update() {

        if (isPlacingDef) {
            gp.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        } else {
            gp.setCursor(Cursor.getDefaultCursor());
        }
        if (uiPanel.equals("competence")) {
            if (gp.mouseH.mousePressedVar) {
                if (gp.playerXP.cPAvailable > 0) {
                    Point mousePoint = new Point(gp.mouseH.x, gp.mouseH.y);

                    if (btnSeeHealthBar.contains(mousePoint)) {


                        if (gp.player.canViewHealthBar == false) {
                            gp.mouseH.mousePressedVar = false;
                            gp.playerXP.cPAvailable -= 1;
                            gp.playerXP.cPUsed += 1;
                        }
                        gp.player.canViewHealthBar = true;


                    }
                    if (btnSpeedUpgrade.contains(mousePoint) && gp.player.speedMultiplier < 1.32) {
                        gp.player.speedMultiplier += 0.08;

                        gp.mouseH.mousePressedVar = false;
                        gp.playerXP.cPAvailable -= 1;
                        gp.playerXP.cPUsed += 1;

                    }
                    if (btnEnduranceUpgrade.contains(mousePoint) && gp.player.maxEndurance < 8) {
                        gp.player.maxEndurance += 1;

                        gp.mouseH.mousePressedVar = false;
                        gp.playerXP.cPAvailable -= 1;
                        gp.playerXP.cPUsed += 1;

                    }


                }
            }
        }
        if (uiGameover == true) {
            if (gp.mouseH.mousePressedVar) {
                Point mousePoint = new Point(gp.mouseH.x, gp.mouseH.y);
                if (btnRetry.contains(mousePoint)) {
                    gp.GameState = gp.PlayState;
                    uiGameover = false;
                    gp.player.setDefaultValues();
                    aSetter.setItem();
                    aSetter.setMonster();
                    gp.playerXP.setDefaultXP();
                    gp.dayCycle.setDefaultTime();
                    //c'est mieux comme ça
                    for (int i =0; i < gp.defense.length; i++) {
                        gp.defense[i] = null;
                    }
                }
            }

        }



        if (uiInventory == true) {
            if (gp.mouseH.mousePressedVar) {
                Point mousePoint = new Point(gp.mouseH.x, gp.mouseH.y);
                if (btnCanon.contains(mousePoint)) {
                    isPlacingDef = true;
                    gp.mouseH.mousePressedVar = false;
                    defType="canon";
                }
            }

        }
        if (isPlacingDef == true) {
            if (gp.mouseH.mousePressedVar) {


                Point mousePoint = new Point(gp.mouseH.x, gp.mouseH.y);
                int mouseX = mousePoint.x;
                int mouseY = mousePoint.y;

                int worldMouseX = mouseX + gp.player.worldx - gp.player.screenX;
                int worldMouseY = mouseY + gp.player.worldy - gp.player.screenY;

                int col = worldMouseX / gp.tileSize;
                int row = worldMouseY / gp.tileSize;
                    if (col >= 0 && row >= 0 && col < gp.tileM.mapTileNumber.length && row < gp.tileM.mapTileNumber[0].length) {
                        int clickedTileID = 0;
                        if (clickedTileID == 0) {

                            dManager.addDefense(defType, col * gp.tileSize, row * gp.tileSize);

                            isPlacingDef = false;
                            gp.mouseH.mousePressedVar = false;


                        }
                    }
                }
            }
        }
    }