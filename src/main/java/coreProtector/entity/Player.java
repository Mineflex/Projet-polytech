package coreProtector.entity;

import coreProtector.gameGestion.GamePanel;
import coreProtector.gameGestion.KeyHandler;
import coreProtector.gameGestion.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;

public class Player extends Entity{
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    //Données inventaire
    public int goldCoin=0;
    public int oak=10;
    public int birch=0;
    public int darkOak=0;
    public int cherryWood=0;
    public int woodBrazier=0;
    public int chargedWood=0;
    public int rock=10;
    public int iron=0;
    public int titane=0;
    public int rubis=0;
    public int onyx=0;
    public int chargedRock=0;
    public int volcanicRock=0;
    public int sand=0;
    public int runeBrazier=0;
    public int chargedRune=0;
    public int physicalRune=0;



    //Valeurs par defaut competence
    public float speedMultiplier=1;
    int frameCounter=0;
    public int maxEndurance=4;
    public int endurance = 4; // duree de la course
    public int enduranceCooldown=12; //duree de la recuperation de l'endurance
    int strengthMultiplier=1;
    public int ressourcesFortune=1;
    public int goldFortune=1;
    public boolean canViewHealthBar=false; //Voir la vie du core meme a distance
    boolean repairKit=false; //Repare petit a petit les defenses si il est tres tres proche d'elles


    public Player(GamePanel gp, KeyHandler keyH){




        super(gp);
        sizeMultiplier=1;


        this.keyH=keyH;

        //On gefinie ses coordonnées sur l'ecran, ici au centre /!\ Haut gauche = x:0 y:0, le 00 n'est pas au centre
        screenX = gp.screenWidth/2 - gp.tileSize*sizeMultiplier/2;
        screenY=gp.screenHeight/2 - gp.tileSize*sizeMultiplier/2;

        //On fait une hitbox pour le joueur plus petite pour faciliter le mouvement entre deux tiles avec une collision
        hitBox=new Rectangle(0 + gp.scale *8*sizeMultiplier,0 + gp.scale *8*sizeMultiplier ,gp.scale*16*sizeMultiplier,gp.scale*16*sizeMultiplier);
        hitBoxDefaultX=hitBox.x;
        hitBoxDefaultY=hitBox.y;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){

        //Ses coordonnées et propriétées lors du spawn
        worldx = gp.tileSize *25;
        worldy = gp.tileSize *25;
        speed = 4 ;
        direction= "up";
    }

    public void getPlayerImage(){



        up1=setup("/playerSprites/player_sprite12");
        up2=setup("/playerSprites/player_sprite13");
        up3=setup("/playerSprites/player_sprite14");
        up4=setup("/playerSprites/player_sprite15");
        left1=setup("/playerSprites/player_sprite04");
        left2=setup("/playerSprites/player_sprite05");
        left3=setup("/playerSprites/player_sprite06");
        left4=setup("/playerSprites/player_sprite07");
        down1=setup("/playerSprites/player_sprite00");
        down2=setup("/playerSprites/player_sprite01");
        down3=setup("/playerSprites/player_sprite02");
        down4=setup("/playerSprites/player_sprite04");
        right1=setup("/playerSprites/player_sprite08");
        right2=setup("/playerSprites/player_sprite09");
        right3=setup("/playerSprites/player_sprite10");
        right4=setup("/playerSprites/player_sprite11");
        hitDown1=setup("/playerSprites/player_sprite16");
        hitDown2=setup("/playerSprites/player_sprite17");
        hitUp1=setup("/playerSprites/player_sprite18");
        hitUp2=setup("/playerSprites/player_sprite19");
        hitLeft1=setup("/playerSprites/player_sprite20");
        hitLeft2=setup("/playerSprites/player_sprite21");
        hitRight1=setup("/playerSprites/player_sprite22");
        hitRight2=setup("/playerSprites/player_sprite23");

    }

    public  void update(){

        if (keyH.showCompetenceUiBool){

                gp.ui.uiPanel="competence";
        }else {
            gp.ui.uiPanel="basic";
        }
        if (keyH.showControlMenu){
            gp.ui.showControl=true;
        }else {
            gp.ui.showControl=false;

        }
        if (keyH.showInventoryMenu){
            gp.ui.uiInventory=true;
        }else {
            gp.ui.uiInventory=false;
        }


        //On reagit si le joueur appuis sur une touche specfique liée au mouvement
        if (keyH.upPressed || keyH.downPressed|| keyH.leftPressed|| keyH.rightPressed|| keyH.spacePressed){
            if(keyH.upPressed==true){
                direction="up";
            }
            else if(keyH.downPressed==true){
                direction="down";
            }else if(keyH.leftPressed==true){
                direction="left";
            }else if(keyH.rightPressed==true){
                direction="right";
            }
            if (keyH.sprintPressed && endurance>0 && (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) && keyH.spacePressed==false){
                speed=8;
                spriteCounter++;

                frameCounter++;
                if(frameCounter >=60){
                    endurance-=1;
                    frameCounter=0; //Nathan base toi sur cette variable pour le systeme d'heure, fait une classe DayCycle et puis bah bonne chance mdrr
                }


            }else if (keyH.spacePressed) {
                speed = 0;
            }
            else {
                speed = 4;
            }


            spriteCounter++;

            collisionOn=false;
            gp.collisionM.checkTile(this);
            int itemIndex =gp.collisionM.checkItem(this,true);
            pickupItem(itemIndex);

            int monsterIndex=gp.collisionM.checkEntity(this, gp.monster);



            //si il n'est pas bloquer par un bloc avec collision, il avance /!\ 00: haut gauche de l'ecran
            if (collisionOn==false){
                switch (direction){
                    case "up":
                        worldy-=speed*speedMultiplier;
                        break;
                    case "down":
                        worldy+=speed*speedMultiplier;
                        break;
                    case "left":
                        worldx-=speed*speedMultiplier;
                        break;
                    case "right":
                        worldx+=speed*speedMultiplier;
                        break;
                }
            }



            //Faire varié les sprites pour faire l'animation
            if(spriteCounter>10){
                if(spriteNum==1){
                    spriteNum=2;
                }
                else if (spriteNum==2){
                    spriteNum=3;
                }else if (spriteNum==3){
                    spriteNum=4;
                }else if (spriteNum==4){
                    spriteNum=1;
                }
                spriteCounter=0;
            }
        }

        if (keyH.sprintPressed ==false){
            frameCounter++;
            if (frameCounter == enduranceCooldown*10  && maxEndurance>endurance){
                endurance+=1;
                frameCounter=0;
            }
        }



    }


    public void pickupItem(int index){
        if (index!=999){
            String itemName= gp.itm[index].name;


            switch (itemName){
                case "ExperienceOrb":
                    gp.playerXP.updateExperience(gp.itm[index].stack*goldFortune);
                    gp.itm[index]=null;


                    break;
            }

        }

    }


//Dessiner le joueur selon sa direction et le sprite actuelle de l'animation
    public void draw(Graphics2D g2){

        BufferedImage image=null;

        // comme un if mais on a pas a faire que ecrire direction == etc
        switch (direction){
            case "up":
                if(spriteNum==1){
                    image=up1;
                }if(spriteNum==2){
                image=up2;}
                if(spriteNum==3){
                    image=up3;}
                if(spriteNum==4){
                    image=up4;}
                if(keyH.spacePressed){
                    if(spriteNum==1) {
                        image = up1;
                    }
                    if(spriteNum==2){
                        image=hitUp1;
                    }
                    if(spriteNum==3){
                        image=hitUp2;
                        //pour celui qui s'occupera de la zone de frape pour les mobs (peut-être moi) faites : postion du mob sur la carte + postion de la box - écart entre coordonées screen et postion du mob
                        hitzone=new Rectangle(screenX + gp.scale *8*sizeMultiplier,screenY - 50 + gp.scale *8*sizeMultiplier ,gp.scale*16*sizeMultiplier,gp.scale*16*sizeMultiplier);
                        g2.setColor(Color.white);
                        g2.fillRect(screenX + gp.scale *8*sizeMultiplier,screenY - 50 + gp.scale *8*sizeMultiplier ,gp.scale*16*sizeMultiplier,gp.scale*16*sizeMultiplier);
                        hitzoneDefaultX=hitzone.x;
                        hitzoneDefaultY=hitzone.y;
                    }
                    if(spriteNum==4) {
                        image = up4;
                    }
                }

                break;

            case "down":
                if(spriteNum==1){
                    image=down1;
                }if(spriteNum==2){
                image=down2;}
                if(spriteNum==3){
                    image=down3;}
                if(spriteNum==4){
                    image=down4;}
                if(keyH.spacePressed) {
                    if (spriteNum == 1) {
                        image = down1;
                    }
                    if (spriteNum == 2) {
                        image = hitDown1;
                    }
                    if (spriteNum == 3) {
                        image = hitDown2;
                        //pour celui qui s'occupera de la zone de frape pour les mobs (peut-être moi) faites : postion du mob sur la carte + postion de la box - écart entre coordonées screen et postion du mob
                        hitzone=new Rectangle(screenX + gp.scale *8*sizeMultiplier,screenY + 75 + gp.scale *8*sizeMultiplier ,gp.scale*16*sizeMultiplier,gp.scale*16*sizeMultiplier);
                        g2.setColor(Color.white);
                        g2.fillRect(screenX + gp.scale *8*sizeMultiplier,screenY + 75 + gp.scale *8*sizeMultiplier ,gp.scale*16*sizeMultiplier,gp.scale*16*sizeMultiplier);
                        hitzoneDefaultX=hitzone.x;
                        hitzoneDefaultY=hitzone.y;
                    }
                    if (spriteNum == 4) {
                        image = down4;
                    }
                }

                break;

            case "left":
                if(spriteNum==1){
                    image=left1;
                }if(spriteNum==2){
                image=left2;}
                if(spriteNum==3){
                    image=left3;}
                if(spriteNum==4){
                    image=left4;}
                if(keyH.spacePressed) {
                    if (spriteNum == 1) {
                        image = left1;
                    }
                    if (spriteNum == 2) {
                        image = hitLeft1;
                    }
                    if (spriteNum == 3) {
                        image = hitLeft2;
                        //pour celui qui s'occupera de la zone de frape pour les mobs (peut-être moi) faites : postion du mob sur la carte + postion de la box - écart entre coordonées screen et postion du mob
                        hitzone=new Rectangle(screenX - 50 + gp.scale *8*sizeMultiplier,screenY + 25 + gp.scale *8*sizeMultiplier ,gp.scale*16*sizeMultiplier,gp.scale*16*sizeMultiplier);
                        g2.setColor(Color.white);
                        g2.fillRect(screenX - 50 + gp.scale *8*sizeMultiplier,screenY+ 25 + gp.scale *8*sizeMultiplier ,gp.scale*16*sizeMultiplier,gp.scale*16*sizeMultiplier);
                        hitzoneDefaultX=hitzone.x;
                        hitzoneDefaultY=hitzone.y;
                    }
                    if (spriteNum == 4) {
                        image = left4;
                    }
                }
                break;

            case "right":
                if(spriteNum==1){
                    image=right1;
                }if(spriteNum==2){
                image=right2;}
                if(spriteNum==3){
                    image=right3;}
                if(spriteNum==4){
                    image=right4;}
                if(keyH.spacePressed) {
                    if (spriteNum == 1) {
                        image = right1;
                    }
                    if (spriteNum == 2) {
                        image = hitRight1;
                    }
                    if (spriteNum == 3) {
                        image = hitRight2;
                        //pour celui qui s'occupera de la zone de frape pour les mobs (peut-être moi) faites : postion du mob sur la carte + postion de la box - écart entre coordonées screen et postion du mob
                        hitzone=new Rectangle(screenX + 50 + gp.scale *8*sizeMultiplier,screenY + 25 + gp.scale *8*sizeMultiplier ,gp.scale*16*sizeMultiplier,gp.scale*16*sizeMultiplier);
                        g2.setColor(Color.white);
                        g2.fillRect(screenX + 50 + gp.scale *8*sizeMultiplier,screenY + 25 + gp.scale *8*sizeMultiplier ,gp.scale*16*sizeMultiplier,gp.scale*16*sizeMultiplier);
                        hitzoneDefaultX=hitzone.x;
                        hitzoneDefaultY=hitzone.y;
                    }
                    if (spriteNum == 4) {
                        image = right4;
                    }
                }
                break;
        }

        g2.drawImage(image,screenX,screenY,null);




    }


}