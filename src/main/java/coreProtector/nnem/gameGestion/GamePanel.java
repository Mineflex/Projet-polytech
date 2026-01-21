package coreProtector.nnem.gameGestion;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    //paramettres de l'ecran---------------

    final int originalTileSize=32; // la taille de chacun de nos sprites et tiles (pixel art)
    final int scale=3; // un multiplicateur pour augmenter la taille sur l'ecran car sinon tout est minuscule
    final int tileSize= originalTileSize*scale; // La taille visible, donc agrandie, en pixel de chaque sprites

    final int maxScreenCol=16; //Le nombre max de tiles en largeur sur l'ecran
    final int maxSreenRow=12; // idem mais en longueurs
    final int screenWidth=tileSize*maxScreenCol; // la taille final de l'ecran
    final int screenHeight=tileSize*maxSreenRow;//    ^
    //-------------------------------------

azafzafza
    // creer un un panel qui va prendre toutes les info utiles de l'ecran pour y afficher
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }


}
