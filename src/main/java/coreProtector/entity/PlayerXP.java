package coreProtector.entity;

import coreProtector.gameGestion.GamePanel;

import java.awt.image.renderable.RenderableImage;

public class PlayerXP   {
    GamePanel gp;
    public int playerLevel;
    public double playerExPo;
    public double nextLevel;
    public  int cPAvailable;
    public int cPUsed;

    public PlayerXP(GamePanel gp){
        this.gp=gp;
    }

    public void setDefaultXP(){
        //ici qu'il faut changer les valeurs si jamais :)
        playerLevel=0;
        playerExPo=0;
        nextLevel=100;
        cPAvailable=0;
        cPUsed=0;
    }
    public void updateExperience(double amount) {
        playerExPo += amount * gp.player.goldFortune;

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

