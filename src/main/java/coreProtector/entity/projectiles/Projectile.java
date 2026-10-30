package coreProtector.entity.projectiles;

import coreProtector.entity.Entity;
import coreProtector.gameGestion.GamePanel;

import java.util.ArrayList;

public class Projectile extends Entity {
    GamePanel gp;
    Entity user;
    ArrayList<Integer> mobInFire;

    public Projectile(GamePanel gp) {
        super(gp);
        this.gp=gp;

    }

    public void set(int worldX, int worldY, String direction, boolean alive, Entity defense){
        this.worldx=worldX;
        this.worldy=worldY;
        this.alive=alive;
        this.user=defense;
        this.direction=direction;
        this.life=this.maxLife;

        mobInFire=new ArrayList<>();
    }

    public void update(){


        int monsterIndex= gp.collisionM.checkEntity(this, gp.monster);

         if (monsterIndex !=999){

                if (name=="Fire") {
                    if (!mobInFire.contains(monsterIndex)) {

                        mobInFire.add(monsterIndex);
                        gp.monster[monsterIndex].life -= strength;
                    }

                }else {
                    gp.monster[monsterIndex].life-=strength;
                    alive=false;
                }






        }


        switch (direction){
            case "up":
                worldy-=speed;
                break;
            case "down":worldy+=speed;
            break;
            case "left" : worldx+=speed;
            break;
            case "right": worldx-=speed;
            break;
        }

        life--;
        if (life<=0){
            alive=false;
        }

        spriteNum=1;
    }
}
