package coreProtector.entity;

import coreProtector.gameGestion.GamePanel;

import java.awt.image.renderable.RenderableImage;

public class PlayerXP   {
    public int playerLevel;
    public double playerExPo;
    public double nextLevel;
    public  int cPAvailable;
    public int cPUsed;

    public void setDefaultXP(){
        playerLevel=0;
        playerExPo=0;
        nextLevel=100;
        cPAvailable=0;
        cPUsed=0;
    }
    public void updateExperience(double amount) {
        playerExPo += amount;

        while (playerExPo >= nextLevel) {
            levelUp();

        }
    }

    private void levelUp() {
        double surplus = playerExPo - nextLevel;
        playerLevel++;

        nextLevel = Math.round(100 * Math.pow(1.2, playerLevel));

        playerExPo = surplus;
        cPAvailable+=1;
    }


}

