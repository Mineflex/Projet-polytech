package coreProtector.gameGestion;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {
    public int x,y;
    public boolean mousePressed = false;
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        x= e.getX();
        y=e.getY();
        mousePressed=true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mousePressed=false;

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
