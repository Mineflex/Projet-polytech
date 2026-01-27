package coreProtector.entity;

import coreProtector.gameGestion.GamePanel;
import coreProtector.gameGestion.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gp, KeyHandler keyH){

        this.gp=gp;
        this.keyH=keyH;

        screenX = gp.screenWidth/2 - gp.tileSize/2;
        screenY=gp.screenHeight/2 - gp.tileSize/2;

        hitBox=new Rectangle(0 + gp.scale *8,0 + gp.scale *8 ,gp.scale*16,gp.scale*16);


        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){

        worldx = gp.tileSize *20;
        worldy = gp.tileSize *20;
        speed = 4;
        direction= "up";
    }

    public void getPlayerImage(){
        try {
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

            if (keyH.sprintPressed){
                speed=8;
                spriteCounter++;
            }else {
                speed=4;
            }

            spriteCounter++;

            collisionOn=false;
            gp.collisionM.checkTile(this);
            if (collisionOn==false){
                switch (direction){
                    case "up":
                        worldy-=speed;
                        break;
                    case "down":
                        worldy+=speed;
                        break;
                    case "left":
                        worldx-=speed;
                        break;
                    case "right":
                        worldx+=speed;
                        break;
                }
            }

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

        g2.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize,null);




    }
}