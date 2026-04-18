package coreProtector.gameGestion;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed,downPressed,leftPressed,rightPressed,sprintPressed,spacePressed;
    public boolean showCompetenceUiBool =false;
    public boolean showControlMenu =true;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code=e.getKeyCode();
        //pour detecter quand Z est presser, puis les lignes d'apres c'est pour le reste des touches utiles


        //Mouvement----------------------------------------
        if (code==KeyEvent.VK_Z){
            upPressed=true;
        }
        if (code==KeyEvent.VK_S){
            downPressed=true    ;
        }if (code==KeyEvent.VK_Q){
            leftPressed=true;
        }if (code==KeyEvent.VK_D){
            rightPressed=true;
        }
        //Sprint------------------------------------------
        if (code==KeyEvent.VK_SHIFT){
            sprintPressed=true;
        }
        //---------------------------------
        //----------------------------------

        //Action-------------------------------------------
        //taper
        if (code==KeyEvent.VK_SPACE){
            spacePressed=true;
        }

        //UI------------------------------------------------
        if (code==KeyEvent.VK_C){
            showCompetenceUiBool = !showCompetenceUiBool;
        }
        if (code==KeyEvent.VK_TAB){
            showControlMenu = !showControlMenu;
        }
        //-----------------------------------------------
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code=e.getKeyCode();
        //pour detecter quand Z est relaché, puis les lignes d'apres c'est pour le reste des touches utiles

        if (code==KeyEvent.VK_Z){
            upPressed=false;
        }
        if (code==KeyEvent.VK_S){
            downPressed=false;
        }if (code==KeyEvent.VK_Q){
            leftPressed=false;
        }if (code==KeyEvent.VK_D){
            rightPressed=false;
        }
        if (code==KeyEvent.VK_SHIFT){
            sprintPressed=false;
        }
        if (code==KeyEvent.VK_SPACE){
            spacePressed=false;
        }

    }

}
