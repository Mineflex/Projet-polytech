package coreProtector.items;

import coreProtector.gameGestion.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperItem {

    public BufferedImage image;
    public  String name;
    public boolean collision=false;
    public int worldX, worldY;
    GamePanel gp;
    public  Rectangle hitBox = new Rectangle(0,0,32* gp.scale, 32* gp.scale);
    public int  hitBoxDefaultX=0;
    public int  hitBoxDefaultY=0;

    public void draw(Graphics2D g2, GamePanel gp){
        int screenX= worldX-gp.player.worldx +gp.player.screenX;
        int screenY= worldY-gp.player.worldy+gp.player.screenY;

        //afficher que la partie visible de la map sur l'ecran pour eviter le lag
        if(worldX + (gp.tileSize) *2 >gp.player.worldx - gp.player.screenX  && worldX - (gp.tileSize) *2 <gp.player.worldx+gp.player.screenX &&  worldY +(gp.tileSize) *2 >gp.player.worldy-gp.player.screenY && worldY-(gp.tileSize) *2 < gp.player.worldy+gp.player.screenY){
            g2.drawImage( image, screenX,screenY,gp.tileSize,gp.tileSize,null);
        }
    }
}
