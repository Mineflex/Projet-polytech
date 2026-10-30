package coreProtector.entity.defenses;

import coreProtector.entity.Entity;
import coreProtector.entity.projectiles.CanonBall;
import coreProtector.entity.projectiles.Fire;
import coreProtector.gameGestion.GamePanel;

import java.awt.*;

public class FlameThrower extends Entity{


    GamePanel gp;


    public FlameThrower(GamePanel gp) {
        super(gp);
        projectile=  new Fire(gp);

        name= "Flame Thrower";
        speed =0;
        maxLife=5;
        life=maxLife;
        int defenseLevel=1;
        maxCooldown=65*3;
        cooldown=65*3;
        this.gp=gp;
        hitBox=new Rectangle(0 + gp.scale *8*sizeMultiplier,0 + gp.scale *8*sizeMultiplier ,gp.scale*16*sizeMultiplier,gp.scale*16*sizeMultiplier);
        hitBoxDefaultY=hitBox.y;

        getImage();
    }
    public void getImage(){

        up1=setup("/defense/Flamethrower/lvl1_flameT_sprite_10");
        up2=setup("/defense/Flamethrower/lvl1_flameT_sprite_10");
        up3=setup("/defense/Flamethrower/lvl1_flameT_sprite_10");
        up4=setup("/defense/Flamethrower/lvl1_flameT_sprite_10");
        down1=setup("/defense/Flamethrower/lvl1_flameT_sprite_08");
        down2=setup("/defense/Flamethrower/lvl1_flameT_sprite_09");
        down3=setup("/defense/Flamethrower/lvl1_flameT_sprite_08");
        down4=setup("/defense/Flamethrower/lvl1_flameT_sprite_07");
        left1=setup("/defense/Flamethrower/lvl1_flameT_sprite_05");
        left2=setup("/defense/Flamethrower/lvl1_flameT_sprite_06");
        left3=setup("/defense/Flamethrower/lvl1_flameT_sprite_05");
        left4=setup("/defense/Flamethrower/lvl1_flameT_sprite_04");
        right1=setup("/defense/Flamethrower/lvl1_flameT_sprite_02");
        right2=setup("/defense/Flamethrower/lvl1_flameT_sprite_03");
        right3=setup("/defense/Flamethrower/lvl1_flameT_sprite_02");
        right4=setup("/defense/Flamethrower/lvl1_flameT_sprite_01");
        hitDown1=setup("/playerSprites/player_sprite16");
        hitDown2=setup("/playerSprites/player_sprite17");
        hitUp1=setup("/playerSprites/player_sprite18");
        hitUp2=setup("/playerSprites/player_sprite19");
        hitLeft1=setup("/playerSprites/player_sprite20");
        hitLeft2=setup("/playerSprites/player_sprite21");
        hitRight1=setup("/playerSprites/player_sprite22");
        hitRight2=setup("/playerSprites/player_sprite23");




    }public void setAction(){
        cooldown--;
        if (cooldown<=0){

            projectile.set(worldx,worldy,direction,true,this);
            gp.projectileList.add(projectile);
            cooldown=maxCooldown;
        }

    }



}
