package coreProtector.gameGestion;

import coreProtector.entity.Entity;

public class CollisionManager {

    GamePanel gp;

    public CollisionManager(GamePanel gp){
        this.gp = gp;
    }

    public  void checkTile(Entity entity){
        int entityLeftWorldX=entity.worldx + entity.hitBox.x;
        int entityRightWorldX=entity.worldx+entity.hitBox.x + entity.hitBox.width;
        int entityTopWorldY=entity.worldy+entity.hitBox.y;
        int entityBottomWorldY=entity.worldy+entity.hitBox.y + entity.hitBox.height;

        int entityLeftCol= entityLeftWorldX/gp.tileSize;
        int entityRightCol=entityRightWorldX/gp.tileSize;
        int entityTopRow=entityTopWorldY/ gp.tileSize;
        int entityBottomRow=entityBottomWorldY/gp.tileSize;

        int tileNum1, tileNum2;

        switch (entity.direction){
            case "up":
                entityTopRow = (entityTopWorldY-entity.speed)/gp.tileSize;

                tileNum1=gp.tileM.mapTileNumber[entityLeftCol][entityTopRow];//on verifie les cases ou l'entité peu se heurter lorsqu'il avance dans une certaine directio,
                tileNum2=gp.tileM.mapTileNumber[entityRightCol][entityTopRow];//idem
                if(gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision){//Si il se heurte a une case avec une hitbox il y a colision
                    entity.collisionOn =true;
                }

                break;
            case "down":
                entityBottomRow=(entityBottomWorldY +entity.speed)/gp.tileSize;
                tileNum1=gp.tileM.mapTileNumber[entityLeftCol][entityBottomRow];
                tileNum2=gp.tileM.mapTileNumber[entityRightCol][entityBottomRow];
                if(gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision){
                    entity.collisionOn =true;
                }

                break;

            case "left":
                entityLeftCol = (entityLeftWorldX-entity.speed)/gp.tileSize;
                tileNum1=gp.tileM.mapTileNumber[entityLeftCol][entityTopRow];
                tileNum2=gp.tileM.mapTileNumber[entityLeftCol][entityBottomRow];
                if(gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision){
                    entity.collisionOn =true;
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX+entity.speed)/gp.tileSize;
                tileNum1=gp.tileM.mapTileNumber[entityRightCol][entityTopRow];
                tileNum2=gp.tileM.mapTileNumber[entityRightCol][entityBottomRow];
                if(gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision){
                    entity.collisionOn =true;
                }
                break;
        }

    }
    public int checkItem(Entity entity, boolean isPlayer){
        int index=999;

        for (int i=0;i<gp.itm.length;i++){
            if(gp.itm[i]!=null){
                entity.hitBox.x=entity.worldx+entity.hitBox.x;
                entity.hitBox.y=entity.worldy+entity.hitBox.y;

                gp.itm[i].hitBox.x=gp.itm[i].worldX+gp.itm[i].hitBox.x;
                gp.itm[i].hitBox.y=gp.itm[i].worldY+gp.itm[i].hitBox.y;

                switch (entity.direction){
                    case "up":
                        entity.hitBox.y-=entity.speed;
                        if (entity.hitBox.intersects(gp.itm[i].hitBox)){
                            if(gp.itm[i].collision=true){
                                entity.collisionOn=true;
                            }
                            if(isPlayer == true){
                                index =i;
                            }
                        }
                        break;

                    case "down":
                        entity.hitBox.y+=entity.speed;
                        if (entity.hitBox.intersects(gp.itm[i].hitBox)){
                            if(gp.itm[i].collision=true){
                                entity.collisionOn=true;
                            }
                            if(isPlayer == true){
                                index =i;
                            }
                        }
                        break;
                    case "left":
                        entity.hitBox.x-=entity.speed;
                        if (entity.hitBox.intersects(gp.itm[i].hitBox)){
                            if(gp.itm[i].collision=true){
                                entity.collisionOn=true;
                            }
                            if(isPlayer == true){
                                index =i;
                            }
                        }
                        break;
                    case "right":
                        entity.hitBox.x+=entity.speed;
                        if (entity.hitBox.intersects(gp.itm[i].hitBox)){
                            if(gp.itm[i].collision=true){
                                entity.collisionOn=true;
                            }
                            if(isPlayer == true){
                                index =i;
                            }
                        }
                        break;
                }
                entity.hitBox.x=entity.hitBoxDefaultX;
                entity.hitBox.y=entity.hitBoxDefaultY;
                gp.itm[i].hitBox.x=gp.itm[i].hitBoxDefaultX;
                gp.itm[i].hitBox.y=gp.itm[i].hitBoxDefaultY;
            }
        }

        return index;
    }


}
