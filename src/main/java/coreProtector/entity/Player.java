package coreProtector.entity;

import coreProtector.gameGestion.GamePanel;
import coreProtector.gameGestion.KeyHandler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;
    public int goldCoin=0;



    //Valeurs par defaut competence
    public float speedMultiplier=1;
    int frameCounter=0;
    public int maxEndurance=5;
    public int endurance = 3; // duree de la course
    public int enduranceCooldown=5; //duree de la recuperation de l'endurance
    int strangeMultiplier=1;
    public int ressourcesFortune=1;
    public int goldFortune=1;
    public boolean canViewHealthBar=false; //Voir la vie du core meme a distance
    boolean repairKit=false; //Repare petit a petit les defenses si il est tres tres proche d'elles


    public Player(GamePanel gp, KeyHandler keyH){
        sizeMultiplier=1;





        this.gp=gp;
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
        try {
            //On recupere tout le sprites pour chaque animation
            left1= ImageIO.read(getClass().getResourceAsStream("/playerSprites/player_sprite04.png"));
            left2= ImageIO.read(getClass().getResourceAsStream("/playerSprites/player_sprite05.png"));
            left3= ImageIO.read(getClass().getResourceAsStream("/playerSprites/player_sprite06.png"));
            left4= ImageIO.read(getClass().getResourceAsStream("/playerSprites/player_sprite07.png"));
            down1= ImageIO.read(getClass().getResourceAsStream("/playerSprites/player_sprite00.png"));
            down2= ImageIO.read(getClass().getResourceAsStream("/playerSprites/player_sprite01.png"));
            down3= ImageIO.read(getClass().getResourceAsStream("/playerSprites/player_sprite02.png"));
            down4= ImageIO.read(getClass().getResourceAsStream("/playerSprites/player_sprite03.png"));
            right1= ImageIO.read(getClass().getResourceAsStream("/playerSprites/player_sprite08.png"));
            right2= ImageIO.read(getClass().getResourceAsStream("/playerSprites/player_sprite09.png"));
            right3= ImageIO.read(getClass().getResourceAsStream("/playerSprites/player_sprite10.png"));
            right4= ImageIO.read(getClass().getResourceAsStream("/playerSprites/player_sprite11.png"));
            up1= ImageIO.read(getClass().getResourceAsStream("/playerSprites/player_sprite12.png"));
            up2= ImageIO.read(getClass().getResourceAsStream("/playerSprites/player_sprite13.png"));
            up3= ImageIO.read(getClass().getResourceAsStream("/playerSprites/player_sprite14.png"));
            up4= ImageIO.read(getClass().getResourceAsStream("/playerSprites/player_sprite15.png"));



        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public  void update(){

        if (keyH.showUI){

                gp.ui.uiPanel="competence";
        }else {
            gp.ui.uiPanel="basic";
        }

        //On reagit si le joueur appuis sur une touche specfique liée au mouvement
        if (keyH.upPressed || keyH.downPressed|| keyH.leftPressed|| keyH.rightPressed){
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
            if (keyH.sprintPressed && endurance>0){
                speed=8;
                spriteCounter++;

                frameCounter++;
                if(frameCounter >=60){
                    endurance-=1;
                    frameCounter=0;
                }


            }else {
                speed=4;
                frameCounter++;
                if (frameCounter == 1*60 +enduranceCooldown*60){
                    endurance=maxEndurance;
                    frameCounter=0;
                }
            }




            spriteCounter++;

            collisionOn=false;
            gp.collisionM.checkTile(this);
            int itemIndex =gp.collisionM.checkItem(this,true);
            pickupItem(itemIndex);


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



    }


    public void pickupItem(int index){
        if (index!=999){
            String itemName= gp.itm[index].name;


            switch (itemName){
                case "Block":
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
                break;
        }

        g2.drawImage(image,screenX,screenY,gp.tileSize *sizeMultiplier,gp.tileSize*sizeMultiplier,null);




    }


}