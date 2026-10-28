package coreProtector.gameGestion;

import coreProtector.entity.defenses.Canon;
import coreProtector.entity.defenses.FlameThrower;

import javax.imageio.ImageIO;
import java.awt.Graphics ;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class DefenseManager {

    private GamePanel gp;


    public DefenseManager(GamePanel gp) {
        this.gp = gp;


    }

    public void addDefense(String type,int x, int y) {
        for (int i = 0; i < gp.defense.length; i++) {
            if (gp.defense[i] == null) {



                if (x/gp.tileSize -gp.maxWorldCol/2 <-1 && (y/gp.tileSize -gp.maxWorldRow/2 >=-1 && y/gp.tileSize -gp.maxWorldRow/2 <=1)){

                    switch (type){
                        case "canon":
                            gp.defense[i] = new Canon(gp);

                            break;

                        case "flameThrower":
                            gp.defense[i] = new FlameThrower(gp);

                            break;
                    }


                    gp.defense[i].worldx = x;
                    gp.defense[i].worldy=y;


                    gp.defense[i].direction="right";
                }else if (x/gp.tileSize -gp.maxWorldCol/2 >1 && (y/gp.tileSize -gp.maxWorldRow/2 >=-1 && y/gp.tileSize -gp.maxWorldRow/2 <=1)){
                    switch (type){
                        case "canon":
                            gp.defense[i] = new Canon(gp);

                            break;

                        case "flameThrower":
                            gp.defense[i] = new FlameThrower(gp);

                            break;
                    }


                    gp.defense[i].worldx = x;
                    gp.defense[i].worldy=y;


                    gp.defense[i].direction="left";
                }
                if (y/gp.tileSize -gp.maxWorldRow/2 >1 && (x/gp.tileSize -gp.maxWorldCol/2 >=-1 && x/gp.tileSize -gp.maxWorldCol/2 <=1)){
                    switch (type){
                        case "canon":
                            gp.defense[i] = new Canon(gp);

                            break;

                        case "flameThrower":
                            gp.defense[i] = new FlameThrower(gp);

                            break;
                    }


                    gp.defense[i].worldx = x;
                    gp.defense[i].worldy=y;


                    gp.defense[i].direction="down";

                } else if (y/gp.tileSize -gp.maxWorldRow/2 <-1 && (x/gp.tileSize -gp.maxWorldCol/2 >=-1 && x/gp.tileSize -gp.maxWorldCol/2 <=1) ){
                    switch (type){
                        case "canon":
                            gp.defense[i] = new Canon(gp);

                            break;

                        case "flameThrower":
                            gp.defense[i] = new FlameThrower(gp);

                            break;
                    }


                    gp.defense[i].worldx = x;
                    gp.defense[i].worldy=y;


                    gp.defense[i].direction="up";


                }

                break;
            }
        }
    }




}