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
