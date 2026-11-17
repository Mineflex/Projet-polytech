package coreProtector.entity.projectiles;

import coreProtector.gameGestion.GamePanel;

public class Fire extends Projectile{

    GamePanel gp;
    public Fire(GamePanel gp) {
        super(gp);
        this.gp=gp;


        name="Fire";
        speed=5;
        maxLife=80;
        life=maxLife;
        strength=2;
        getImage();

    }

    public void getImage(){
        down1=setup("/defense/projectile/flame_01");
        down2=setup("/defense/projectile/flame_05");
        down3=setup("/defense/projectile/flame_09");
        down4=setup("/defense/projectile/flame_13");
        up1=setup("/defense/projectile/flame_03");
        up2=setup("/defense/projectile/flame_07");
        up3=setup("/defense/projectile/flame_11");
        up4=setup("/defense/projectile/flame_15");
        right1=setup("/defense/projectile/flame_00");
        right2=setup("/defense/projectile/flame_04");
        right3=setup("/defense/projectile/flame_08");
        right4=setup("/defense/projectile/flame_12");
        left1=setup("/defense/projectile/flame_02");
        left2=setup("/defense/projectile/flame_06");
        left3=setup("/defense/projectile/flame_10");
        left4=setup("/defense/projectile/flame_14");
    }


}
