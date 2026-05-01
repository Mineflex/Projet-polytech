package coreProtector.entity;

import coreProtector.gameGestion.GamePanel;

import java.awt.image.renderable.RenderableImage;

public class PlayerXP   {
    public int playerLevel=0;
    public double playerExPo=0;
    public double nextLevel=100;
    public  int cPAvailable=0;
    public int cPUsed=0;

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

