package coreProtector.gameGestion;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class KeyHandler implements KeyListener {
    GamePanel gp;
    public boolean upPressed,downPressed,leftPressed,rightPressed,sprintPressed,spacePressed;
    public boolean showCompetenceUiBool =false;
    public boolean showControlMenu =true;
    public boolean showInventoryMenu = false;

    public KeyHandler(GamePanel gp){
        this.gp=gp;
    }

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
            if (gp.GameState == gp.PlayState) {
                showControlMenu = !showControlMenu;;
            }
            else if (gp.GameState == gp.GameOverState) {

            }//quand le on est en gameover, ce menue ne s'ouvre plus
        }
        if (code==KeyEvent.VK_E){
            if (gp.GameState == gp.PlayState) {
                showInventoryMenu = !showInventoryMenu;
            }
            else if (gp.GameState == gp.GameOverState) {

            }//quand le on est en gameover, ce menue ne s'ouvre plus
        }
        //test game over-----------------------------------------------
        if (code==KeyEvent.VK_P){
            if (gp.GameState == gp.PlayState) {
                gp.GameState = gp.GameOverState;
                gp.ui.uiGameover = true;
            }
            else {
            }
        }

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
