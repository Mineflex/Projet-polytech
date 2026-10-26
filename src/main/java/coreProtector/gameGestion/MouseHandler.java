package coreProtector.gameGestion;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {
    public int x,y;
    public boolean mousePressedVar = false;
    private GamePanel gp;
    public MouseHandler(GamePanel gp){
        this.gp=gp;
    }

    public MouseHandler() {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }


    @Override
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        mousePressedVar = true;
        if (x >= 0 && x <= 400 && y >= 0 && y <=600) {
            if (y >= 140 && y <= 250 && x<=300) {
                    gp.isPlacingCannon = true;
            }return;
        }
        if (gp.isPlacingCannon) {
            int worldMouseX = x + gp.player.worldx - gp.player.screenX;
            int worldMouseY =  y + gp.player.worldy - gp.player.screenY;

            int col = worldMouseX / gp.tileSize;
            int row = worldMouseY / gp.tileSize;
            if (col >= 0 && row >= 0 && col < gp.tileM.mapTileNumber.length && row < gp.tileM.mapTileNumber[0].length) {
                int clickedTileID = 0;
                if (clickedTileID == 0) {
                gp.defenseManager.addDefense(col * gp.tileSize, row * gp.tileSize);
                gp.isPlacingCannon = false;
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mousePressedVar=false;

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
