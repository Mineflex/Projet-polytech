package coreProtector.entity;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class Entity {
    public  int worldx,worldy; //position des entitées en fonction de la map, et pas de l'ecran
    public int speed; //vitesse des entitées
    public int health;
    public int strength;


    public BufferedImage up1, up2, up3,up4,down1,down2,down3,down4,left1,left2,left3,left4,right1,right2,right3,right4; //L'ensembles des sprites pour chaque animation de chaque entitées
    public BufferedImage hitUp1, hitUp2, hitDown1,hitDown2,hitLeft1,hitLeft2,hitRight1,hitRight2;
    public String direction;//Savoir ou il va

    public int spriteCounter =0;//Pour les animations, voir class player
    public int spriteNum=1;
    public int sizeMultiplier;//Grossir si besoin

    public Rectangle hitBox; //Definir sa hit box
    public int hitBoxDefaultX, hitBoxDefaultY;
    public  boolean collisionOn=false;

    public Rectangle hitzone; //pour définire la zone de frappe
    public int hitzoneDefaultX, hitzoneDefaultY;
}
