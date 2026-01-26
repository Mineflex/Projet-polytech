package coreProtector.tiles;

import coreProtector.gameGestion.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNumber[][];


    public TileManager(GamePanel gp){
        this.gp=gp;

        //ecrire le nombre de tiles dans le jeux
        tile= new Tile[15];
        mapTileNumber= new int[gp.maxWorldCol][gp.maxWorldRow];


        getTileImage();
        loadMap("/maps/mapOverworld.txt");
    }

    public void getTileImage( ){

        try {

            //grass -------------------
            tile[0]=new Tile();
            tile[0].image= ImageIO.read(getClass().getResourceAsStream("/mapTiles/grass_00.png"));

            //------------




        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void loadMap(String map) {
        try {
            InputStream is = getClass().getResourceAsStream(map);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;


            while (row < gp.maxWorldRow) {
                String line = br.readLine();

                if (line == null) break;


                String numbers[] = line.split(" ");


                while (col < gp.maxWorldCol) {
                    int num = Integer.parseInt(numbers[col]);

                    mapTileNumber[col][row] = num;
                    col++;
                }


                if (col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace(); // Affiche l'erreur si le fichier a un problème
        }
    }


    public void draw(Graphics2D g2){

        int worldCol=0;
        int worldRow =0;

        while (worldCol<gp.maxWorldCol && worldRow < gp.maxWorldRow){
            int tileNum = mapTileNumber[worldCol][worldRow];

            int worldX= worldCol * gp.tileSize;
            int worldY= worldRow* gp.tileSize;
            int screenX= worldX-gp.player.worldx +gp.player.screenX;
            int screenY= worldY-gp.player.worldy+gp.player.screenY;

            //afficher que la partie visible de la map sur l'ecran pour eviter le lag
            if(worldX + (gp.tileSize) *2 >gp.player.worldx - gp.player.screenX  && worldX - (gp.tileSize) *2 <gp.player.worldx+gp.player.screenX &&  worldY +(gp.tileSize) *2 >gp.player.worldy-gp.player.screenY && worldY-(gp.tileSize) *2 < gp.player.worldy+gp.player.screenY){
                g2.drawImage( tile[tileNum].image, screenX,screenY,gp.tileSize,gp.tileSize,null);
            }

            worldCol++;

            if(worldCol==gp.maxWorldCol){
                worldCol=0;
                worldRow++;
            }
        }




    }
}
