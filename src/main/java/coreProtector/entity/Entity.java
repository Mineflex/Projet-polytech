package coreProtector.entity;

import coreProtector.gameGestion.GamePanel;
import coreProtector.gameGestion.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;

public class Entity {
    GamePanel gp;

    public  int worldx,worldy; //position des entitées en fonction de la map, et pas de l'ecran
    public int speed; //vitesse des entitées
    public int health;
    public int strength;
    public String name;
    public int maxLife;
    public int life;


    public BufferedImage up1, up2, up3,up4,down1,down2,down3,down4,left1,left2,left3,left4,right1,right2,right3,right4; //L'ensembles des sprites pour chaque animation de chaque entitées
    public BufferedImage hitUp1, hitUp2, hitDown1,hitDown2,hitLeft1,hitLeft2,hitRight1,hitRight2;
    public String direction = "down";//Savoir ou il va

    public int spriteCounter =0;//Pour les animations, voir class player
    public int spriteNum=1;
    public int sizeMultiplier =1;//Grossir si besoin

    public Rectangle hitBox = new Rectangle(0,0,48,48); //Definir sa hit box
    public int hitBoxDefaultX, hitBoxDefaultY;
    public  boolean collisionOn=false;

    public Rectangle hitzone; //pour définire la zone de frappe
    public int hitzoneDefaultX, hitzoneDefaultY;

    public Entity(GamePanel gp){
        this.gp=gp;

    }

    public void setAction(){

    }
    public void update(){
        setAction();

        collisionOn=false;
        gp.collisionM.checkTile(this);
        gp.collisionM.checkItem(this, false);
        gp.collisionM.checkPlayer(this);
        gp.collisionM.checkEntity(this, gp.monster);
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


        spriteCounter++;

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





    public void draw(Graphics2D g2){

        BufferedImage image= null;

        int screenX= worldx-gp.player.worldx +gp.player.screenX;
        int screenY= worldy-gp.player.worldy+gp.player.screenY;


        //afficher que la partie visible de la map sur l'ecran pour eviter le lag
        if(worldx + (gp.tileSize) *2 >gp.player.worldx - gp.player.screenX  && worldx - (gp.tileSize) *2 <gp.player.worldx+gp.player.screenX &&  worldy +(gp.tileSize) *2 >gp.player.worldy-gp.player.screenY && worldy-(gp.tileSize) *2 < gp.player.worldy+gp.player.screenY){


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
            g2.drawImage( image, screenX,screenY,gp.tileSize,gp.tileSize,null);

        }}

    public BufferedImage setup(String imagePath){
        UtilityTool uTool=new UtilityTool();
        BufferedImage scaledImage = null;

        try {
            scaledImage= ImageIO.read(getClass().getResourceAsStream(imagePath+".png"));
            scaledImage=uTool.scaledImage(scaledImage, gp.tileSize,gp.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
        return scaledImage;
    }
}
