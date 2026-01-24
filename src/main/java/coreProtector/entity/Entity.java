package coreProtector.entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    public  int worldx,worldy; //position des entitées en fonction de la map, et pas de l'ecran
    public int speed; //vitesse des entitées

    public BufferedImage up1, up2;
    public String direction;

    public int spriteCounter =0;
    public int spriteNum=1;

    public Rectangle hitBox;
    public  boolean collisionOn=false;
}
