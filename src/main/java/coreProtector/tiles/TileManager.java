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
    Tile[] tile;
    int mapTileNumber[][];


    public TileManager(GamePanel gp){
        this.gp=gp;

        //ecrire le nombre de tiles dans le jeux
        tile= new Tile[1];
        mapTileNumber= new int[gp.maxScreenCol][gp.maxSreenRow];


        getTileImage("/mapTiles/grass.png");
        loadMap();
    }

    public void getTileImage(String filePath){

        try {

            tile[0]=new Tile();
            tile[0].image= ImageIO.read(getClass().getResourceAsStream(filePath));


        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void loadMap(){
        try{
            InputStream is=getClass().getResourceAsStream("/maps/mapOverworld.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col=0;
            int row=0;

            while (col<gp.maxScreenCol && row<gp.maxScreenCol){
                String line= br.readLine();

                while (col<gp.maxScreenCol){
                    String numbers[] =line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNumber[col][row]=num;
                    col++;
                    if (col== gp.maxScreenCol){
                        col=0;
                        row++;
                    }
                }
            }
            br.close();

        }catch (Exception e){

        }
    }


    public void draw(Graphics2D g2){

        int col=0;
        int row=0;
        int x=0;
        int y=0;

        while (col<gp.maxScreenCol && row< gp.maxSreenRow){
            int tileNum = mapTileNumber[col][row];

            g2.drawImage( tile[tileNum].image, x,y,gp.tileSize,gp.tileSize,null);
            col++;
            x+= gp.tileSize;

            if(col==gp.maxScreenCol){
                col=0;
                x=0;
                row++;
                y+=gp.tileSize;
            }
        }




    }
}
