package coreProtector.entity;

import coreProtector.gameGestion.GamePanel;
import coreProtector.gameGestion.KeyHandler;
import coreProtector.gameGestion.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;

public class Player extends Entity{
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    //Données inventaire
    public int goldCoin;
    public int oak;
    public int birch;
    public int darkOak;
    public int cherryWood;
    public int woodBrazier;
    public int chargedWood;
    public int rock;
    public int iron;
    public int titane;
    public int rubis;
    public int onyx;
    public int chargedRock;
    public int volcanicRock;
    public int sand;
    public int runeBrazier;
    public int chargedRune;
    public int physicalRune;



    //Valeurs par defaut competence
    public float speedMultiplier;
    int frameCounter;
    public int maxEndurance;
    public int endurance; // duree de la course
    public int enduranceCooldown; //duree de la recuperation de l'endurance
    int strengthMultiplier;
    public int ressourcesFortune;
    public int goldFortune;
    public boolean canViewHealthBar; //Voir la vie du core meme a distance
    boolean repairKit; //Repare petit a petit les defenses si il est tres tres proche d'elles


    public Player(GamePanel gp, KeyHandler keyH){




        super(gp);
        sizeMultiplier=1;


        this.keyH=keyH;

        //On gefinie ses coordonnées sur l'ecran, ici au centre /!\ Haut gauche = x:0 y:0, le 00 n'est pas au centre
        screenX = gp.screenWidth/2 - gp.tileSize*sizeMultiplier/2;
        screenY=gp.screenHeight/2 - gp.tileSize*sizeMultiplier/2;

        //On fait une hitbox pour le joueur plus petite pour faciliter le mouvement entre deux tiles avec une collision
        hitBox=new Rectangle(0 + gp.scale *8*sizeMultiplier,0 + gp.scale *14*sizeMultiplier,gp.scale*16*sizeMultiplier,gp.scale*16*sizeMultiplier);
        hitBoxDefaultX=hitBox.x;
        hitBoxDefaultY=hitBox.y;

        hitzone.width=gp.scale*8*sizeMultiplier;
        hitzone.height=gp.scale*8*sizeMultiplier;


        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        //ici qu'il faut changer les valeurs si jamais :)
        //Ses coordonnées et propriétées lors du spawn ou après gameOver
        worldx = gp.tileSize *25;
        worldy = gp.tileSize *25;
        speed = 4 ;
        direction= "up";
        //inventaire lors du spawn ou après gameOver
        goldCoin = 0;
        oak=10;
        birch=10;
        darkOak=0;
        cherryWood=0;
        woodBrazier=0;
        chargedWood=0;
        rock=10;
        iron=0;
        titane=0;
        rubis=0;
        onyx=0;
        chargedRock=0;
        volcanicRock=0;
        sand=0;
        runeBrazier=0;
        chargedRune=0;
        physicalRune=0;
        //compétence lors du spawn ou après gameOver
        speedMultiplier=1;
        frameCounter=0;
        maxEndurance=4;
        endurance = 4; // duree de la course
        enduranceCooldown=12; //duree de la recuperation de l'endurance
        strengthMultiplier=1;
        ressourcesFortune=1;
        goldFortune=1;
        canViewHealthBar=false; //Voir la vie du core meme a distance
        repairKit=false; //Repare petit a petit les defenses si il est tres tres proche d'elles


    }

    public void getPlayerImage(){



        up1=setup("/playerSprites/player_sprite12");
        up2=setup("/playerSprites/player_sprite13");
        up3=setup("/playerSprites/player_sprite14");
        up4=setup("/playerSprites/player_sprite15");
        left1=setup("/playerSprites/player_sprite04");
        left2=setup("/playerSprites/player_sprite05");
        left3=setup("/playerSprites/player_sprite06");
        left4=setup("/playerSprites/player_sprite07");
        down1=setup("/playerSprites/player_sprite00");
        down2=setup("/playerSprites/player_sprite01");
        down3=setup("/playerSprites/player_sprite02");
        down4=setup("/playerSprites/player_sprite03");
        right1=setup("/playerSprites/player_sprite08");
        right2=setup("/playerSprites/player_sprite09");
        right3=setup("/playerSprites/player_sprite10");
        right4=setup("/playerSprites/player_sprite11");
        hitDown1=setup("/playerSprites/player_sprite16");
        hitDown2=setup("/playerSprites/player_sprite17");
        hitUp1=setup("/playerSprites/player_sprite18");
        hitUp2=setup("/playerSprites/player_sprite19");
        hitLeft1=setup("/playerSprites/player_sprite20");
        hitLeft2=setup("/playerSprites/player_sprite21");
        hitRight1=setup("/playerSprites/player_sprite22");
        hitRight2=setup("/playerSprites/player_sprite23");

    }

    public  void update(){

        if (keyH.showCompetenceUiBool){

                gp.ui.uiPanel="competence";
        }else {
            gp.ui.uiPanel="basic";
        }
        if (keyH.showControlMenu){
            gp.ui.showControl=true;
        }else {
            gp.ui.showControl=false;

        }
        if (keyH.showInventoryMenu){
            gp.ui.uiInventory=true;
        }else {
            gp.ui.uiInventory=false;
        }


        //On reagit si le joueur appuis sur une touche specfique liée au mouvement
        if (keyH.upPressed || keyH.downPressed|| keyH.leftPressed|| keyH.rightPressed|| keyH.spacePressed ||attacking){
            if(keyH.upPressed==true){
                direction="up";
            }
            else if(keyH.downPressed==true){
                direction="down";
            }else if(keyH.leftPressed==true){
                direction="left";
            }else if(keyH.rightPressed==true){
                direction="right";
            }
            if (keyH.sprintPressed && attacking==false && endurance>0 && (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) && keyH.spacePressed==false) {
                speed = 8;
                spriteCounter++;

                frameCounter++;
                if (frameCounter >= 60) {
                    endurance -= 1;
                    frameCounter = 0; //Nathan base toi sur cette variable pour le systeme d'heure, fait une classe DayCycle et puis bah bonne chance mdrr
                }


            }else if (keyH.spacePressed && !attacking) {
                    speed = 0;
                    attacking = true;
                    spriteNum = 1;
                    spriteCounter = 0;
                    hasHit=true;
                }
            if ( !attacking && keyH.sprintPressed != true){
                speed = 4;
            }

            if (attacking && spriteNum == 3) {
                attacking();
            }



            spriteCounter++;

            collisionOn=false;
            gp.collisionM.checkTile(this);
            int itemIndex =gp.collisionM.checkItem(this,true);
            pickupItem(itemIndex);

            int monsterIndex=gp.collisionM.checkEntity(this, gp.monster);



            //si il n'est pas bloquer par un bloc avec collision, il avance /!\ 00: haut gauche de l'ecran
            if (collisionOn==false){
                switch (direction){
                    case "up":
                        worldy-=speed*speedMultiplier;
                        break;
                    case "down":
                        worldy+=speed*speedMultiplier;
                        break;
                    case "left":
                        worldx-=speed*speedMultiplier;
                        break;
                    case "right":
                        worldx+=speed*speedMultiplier;
                        break;
                }
            }



            //Faire varié les sprites pour faire l'animation
            if (spriteCounter > 10) {
                spriteCounter = 0;

                if (attacking) {
                    if (spriteNum < 4) {
                        spriteNum++;
                    } else {
                        attacking = false;
                        spriteNum = 1;
                    }
                } else {
                    if (spriteNum < 4) {
                        spriteNum++;
                    } else {
                        spriteNum = 1;
                    }
                }
            }
        }

        if (keyH.sprintPressed ==false){
            frameCounter++;
            if (frameCounter == enduranceCooldown*10  && maxEndurance>endurance){
                endurance+=1;
                frameCounter=0;
            }
        }



    }public void attacking() {
        if (spriteNum == 3 ) {
            int oldX = hitBox.x;
            int oldY = hitBox.y;
            int oldWidth = hitBox.width;
            int oldHeight = hitBox.height;

            switch (direction) {
                case "up":
                    hitBox.x += (hitBox.width - hitzone.width) / 2;
                    hitBox.y -= hitzone.height;
                    break;
                case "down":
                    hitBox.x += (hitBox.width - hitzone.width) / 2;
                    hitBox.y += hitBox.height;
                    break;
                case "left":
                    hitBox.x -= hitzone.width;
                    hitBox.y += (hitBox.height - hitzone.height) / 2;
                    break;
                case "right":
                    hitBox.x += hitBox.width;
                    hitBox.y += (hitBox.height - hitzone.height) / 2;
                    break;
            }

            hitBox.width = hitzone.width;
            hitBox.height = hitzone.height;

            int monsterIndex = gp.collisionM.checkAttack(this, gp.monster);
            hitEntity(monsterIndex);

            hitBox.x = oldX;
            hitBox.y = oldY;
            hitBox.width = oldWidth;
            hitBox.height = oldHeight;

        }


    }

    public void pickupItem(int index){
        if (index!=999){
            String itemName= gp.itm[index].name;


            switch (itemName){
                case "ExperienceOrb":
                    gp.playerXP.updateExperience(gp.itm[index].stack*goldFortune);
                    gp.itm[index]=null;


                    break;
                case "oakWoodItem":
                    oak+=1*gp.itm[index].stack * ressourcesFortune;
                    gp.itm[index]=null;
            }

        }

    }
    public void hitEntity( int i){

        if (i !=999 && hasHit==true){
                gp.monster[i].life-=1*strengthMultiplier;
                hasHit=false;



        }


    }


//Dessiner le joueur selon sa direction et le sprite actuelle de l'animation
    public void draw(Graphics2D g2){

        BufferedImage image=null;

        // comme un if mais on a pas a faire que ecrire direction == etc
        switch (direction){
            case "up":
                if (attacking == false) {

                    if(spriteNum==1){
                        image=up1;
                    }if(spriteNum==2){
                        image=up2;}
                    if(spriteNum==3){
                        image=up3;}
                    if(spriteNum==4){
                        image=up4;}
                }else {
                    if(spriteNum==1){
                        image=up1;
                    }if(spriteNum==2){
                        image=hitUp1;}
                    if(spriteNum==3){
                        image=hitUp2;}
                    if(spriteNum==4){
                        image=up4;}
                }



                break;

            case "down":
                if(attacking == false) {


                    if (spriteNum == 1) {
                        image = down1;
                    }
                    if (spriteNum == 2) {
                        image = down2;
                    }
                    if (spriteNum == 3) {
                        image = down3;
                    }
                    if (spriteNum == 4) {
                        image = down4;
                    }
                }else {
                    if(spriteNum==1){
                        image=down1;
                    }if(spriteNum==2){
                        image=hitDown1;}
                    if(spriteNum==3){
                        image=hitDown2;}
                    if(spriteNum==4){
                        image=down4;
                    }
                }

                break;

            case "left":
                if(!attacking) {


                    if (spriteNum == 1) {
                        image = left1;
                    }
                    if (spriteNum == 2) {
                        image = left2;
                    }
                    if (spriteNum == 3) {
                        image = left3;
                    }
                    if (spriteNum == 4) {
                        image = left4;
                    }
                }else {
                    if(spriteNum==1){
                        image=left1;
                    }if(spriteNum==2){
                        image=hitLeft1;}
                    if(spriteNum==3){
                        image=hitLeft2;}
                    if(spriteNum==4){
                        image=left2;}
                }
                break;

            case "right":
                if(!attacking) {


                    if (spriteNum == 1) {
                        image = right1;
                    }
                    if (spriteNum == 2) {
                        image = right2;
                    }
                    if (spriteNum == 3) {
                        image = right3;
                    }
                    if (spriteNum == 4) {
                        image = right4;
                    }
                }else {
                    if(spriteNum==1){
                        image=right1;
                    }if(spriteNum==2){
                        image=hitRight1;}
                    if(spriteNum==3){
                        image=hitRight2;}
                    if(spriteNum==4){
                        image=right4;}
                }
                break;
        }

        g2.drawImage(image,screenX,screenY,null);
        // Afficher la hitbox du joueur en rouge
        g2.setColor(Color.RED);

        g2.drawRect(
                screenX + hitBox.x,
                screenY + hitBox.y,
                hitBox.width,
                hitBox.height
        );

// Afficher la hitbox d'attaque en jaune
        if (attacking && spriteNum == 3) {

            int attackX = screenX + hitBox.x;
            int attackY = screenY + hitBox.y;

            switch (direction) {
                    case "up":
                        attackX += (hitBox.width - hitzone.width) / 2;
                        attackY -= hitzone.height;
                        break;
                    case "down":
                        attackX += (hitBox.width - hitzone.width) / 2;
                        attackY += hitBox.height;
                        break;
                    case "left":
                        attackX -= hitzone.width;
                        attackY += (hitBox.height - hitzone.height) / 2;
                        break;
                    case "right":
                        attackX += hitBox.width;
                        attackY += (hitBox.height - hitzone.height) / 2;
                        break;

            }

            g2.setColor(Color.YELLOW);

            g2.drawRect(
                    attackX,
                    attackY,
                    hitzone.width,
                    hitzone.height
            );
        }




    }


}