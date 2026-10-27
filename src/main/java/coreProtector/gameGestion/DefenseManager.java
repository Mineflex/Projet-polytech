package coreProtector.gameGestion;

import coreProtector.entity.defenses.Canon;

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

                switch (type){
                    case "canon":
                        gp.defense[i] = new Canon(gp);

                        break;

                    case "flameThrower":


                        break;
                }


                gp.defense[i].worldx = x;
                gp.defense[i].worldy=y;
                System.out.println(
                        "Canon créé : x=" + x + ", y=" + y
                );

                break;
            }
        }
    }




}