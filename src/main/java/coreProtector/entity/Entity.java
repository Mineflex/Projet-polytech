package coreProtector.entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    public  int worldx,worldy; //position des entitées en fonction de la map, et pas de l'ecran
    public int speed; //vitesse des entitées

    public BufferedImage up1, up2, up3,up4,down1,down2,down3,down4,left1,left2,left3,left4,right1,right2,right3,right4;
    public String direction;

    public int spriteCounter =0;
    public int spriteNum=1;

    public Rectangle hitBox;
    public  boolean collisionOn=false;
}
