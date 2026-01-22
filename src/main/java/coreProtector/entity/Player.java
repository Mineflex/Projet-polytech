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

    public Player(GamePanel gp, KeyHandler keyH){

        this.gp=gp;
        this.keyH=keyH;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){

        x = 100;
        y = 100;
        speed = 4;
        direction= "up";
    }

    public void getPlayerImage(){
        try {
            up1= ImageIO.read(getClass().getResourceAsStream("/playerSprites/p1.png"));
            up2= ImageIO.read(getClass().getResourceAsStream("/playerSprites/p2.png"));


        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public  void update(){

        if (keyH.upPressed || keyH.downPressed|| keyH.leftPressed|| keyH.rightPressed){
            if(keyH.upPressed==true){
                direction="up";
                y-=speed;
            }
            else if(keyH.downPressed==true){
                direction="down";
                y+=speed;
            }else if(keyH.leftPressed==true){
                direction="left";
                x-=speed;
            }else if(keyH.rightPressed==true){
                direction="right";
                x+=speed;
            }

            if (keyH.sprintPressed){
                speed=6;
            }else {
                speed=4;
            }

            spriteCounter++;
            if(spriteCounter>10){
                if(spriteNum==1){
                    spriteNum=2;
                }
                else if (spriteNum==2){
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
                    image=up2;
            }

                break;

            case "down":
                if(spriteNum==1){
                    image=up1;
                }if(spriteNum==2){
                image=up2;
            }
                break;

            case "left":
                if(spriteNum==1){
                    image=up1;
                }if(spriteNum==2){
                image=up2;
                }
                break;

            case "right":
                if(spriteNum==1){
                    image=up1;
                }if(spriteNum==2){
                image=up2;
                }
                break;
        }

        g2.drawImage(image,x,y,gp.tileSize,gp.tileSize,null);




    }
}
