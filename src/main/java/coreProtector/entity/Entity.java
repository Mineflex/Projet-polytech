package coreProtector.entity;

import java.awt.image.BufferedImage;

public class Entity {
    public  int x,y; //position des entitées
    public int speed; //vitesse des entitées

    public BufferedImage up1, up2;
    public String direction;

    public int spriteCounter =0;
    public int spriteNum=1;
}
