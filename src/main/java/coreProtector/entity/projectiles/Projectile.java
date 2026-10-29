package coreProtector.entity.projectiles;

import coreProtector.entity.Entity;
import coreProtector.gameGestion.GamePanel;

public class Projectile extends Entity {

    Entity user;
    public Projectile(GamePanel gp) {
        super(gp);

    }

    public void set(int worldX, int worldY, String direction, boolean alive, Entity defense){
        this.worldx=worldX;
        this.worldy=worldY;
        this.alive=alive;
        this.user=defense;
        this.direction=direction;
        this.life=this.maxLife;
    }

    public void update(){
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
