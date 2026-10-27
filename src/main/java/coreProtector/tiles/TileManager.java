
package coreProtector.tiles;

import coreProtector.gameGestion.GamePanel;
import coreProtector.gameGestion.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
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
        tile= new Tile[30];
        mapTileNumber= new int[gp.maxWorldCol][gp.maxWorldRow];


        getTileImage();
        loadMap("/maps/mapV2.txt"); //La map qu'on veut generer
    }

    public void getTileImage( ){



            // A faire pour chaque TIles faire tile[l'id].collision=true; pour ajouter une collision pour cette tile


            setup(0, "00_grass_0", false);
            setup(1, "00_grass_1", false);
            setup(2, "00_grass_2", false);
            setup(3, "00_grass_3", false);
            setup(4, "00_grass_4", false);
            setup(5, "00_grass_5", false);
            setup(6, "00_grass_6", false);
            setup(7,"01_path_00", false);
             setup(8,"01_path_01", false);
        setup(9,"01_path_02", false);
        setup(10,"01_path_03", false);
        setup(11,"01_path_04", false);
        setup(12,"01_path_05", false);
        setup(13,"01_path_06", false);
        setup(14,"01_path_07", false);
        setup(15,"01_path_08", false);
        setup(16,"01_path_09", false);
        setup(17,"01_path_10", false);
        setup(18,"01_path_11", false);
        setup(19,"01_path_12", false);



    }

    public void setup(int index, String imagePath, boolean collision){
        UtilityTool uTool=new UtilityTool();

        try {
            tile[index]=new Tile();
            tile[index].image= ImageIO.read(getClass().getResourceAsStream("/mapTiles/"+imagePath +".png"));
            tile[index].image = uTool.scaledImage(tile[index].image, gp.tileSize,gp.tileSize);
            tile[index].collision=collision;

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

                System.out.println(
                        "Ligne " + row + " : " + numbers.length + " tiles"
                );
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
                g2.drawImage( tile[tileNum].image, screenX,screenY,null);
            }

            worldCol++;

            if(worldCol==gp.maxWorldCol){
                worldCol=0;
                worldRow++;
            }
        }




    }
}
