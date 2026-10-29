package coreProtector.entity.projectiles;

import coreProtector.gameGestion.GamePanel;

public class CanonBall extends Projectile{

    GamePanel gp;
    public CanonBall(GamePanel gp) {
        super(gp);
        this.gp=gp;


        name="Canon Ball";
        speed=3;
        maxLife=90*2;
        life=maxLife;
        strength=3;
        getImage();

    }

    public void getImage(){
        up1=setup("/defense/projectile/boulet_canon");
        up2=setup("/defense/projectile/boulet_canon");
        up3=setup("/defense/projectile/boulet_canon");
        up4=setup("/defense/projectile/boulet_canon");
        down1=setup("/defense/projectile/boulet_canon");
        down2=setup("/defense/projectile/boulet_canon");
        down3=setup("/defense/projectile/boulet_canon");
        down4=setup("/defense/projectile/boulet_canon");
        left1=setup("/defense/projectile/boulet_canon");
        left2=setup("/defense/projectile/boulet_canon");
        left3=setup("/defense/projectile/boulet_canon");
        left4=setup("/defense/projectile/boulet_canon");
        right1=setup("/defense/projectile/boulet_canon");
        right2=setup("/defense/projectile/boulet_canon");
        right3=setup("/defense/projectile/boulet_canon");
        right4=setup("/defense/projectile/boulet_canon");
    }


}
