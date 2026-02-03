package coreProtector.gameGestion;

import coreProtector.entity.Player;
import coreProtector.tiles.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements  Runnable{
    //paramettres de l'ecran---------------

    final int originalTileSize=32; // la taille de chacun de nos sprites et tiles (pixel art)
    public final int scale=4; // un multiplicateur pour augmenter la taille sur l'ecran car sinon tout est minuscule
    public final int tileSize= originalTileSize*scale; // La taille visible, donc agrandie, en pixel de chaque sprites

    public final int maxScreenCol=12; //Le nombre max de tiles en largeur sur l'ecran
    public final int maxScreenRow=6; // idem mais en hauteur
    public final int screenWidth=tileSize*maxScreenCol; // la taille final de l'ecran
    public final int screenHeight=tileSize*maxScreenRow;//    ^
    //-------------------------------------

    //parametre monde
    public final int maxWorldCol=50; // nombre max de tile en longueur
    public final int maxWorldRow=50;//^Idem mais en hauteur
    public final int worldWidth= tileSize*maxWorldCol;//^Idem mais en pixel
    public final int worldHeight= tileSize*maxWorldRow;//^Idem mais en hauteur


    int FPS=60;// Fps

    TileManager tileM= new TileManager(this);
    KeyHandler keyH= new KeyHandler();
    Thread gameThread;
    public CollisionManager collisionM= new CollisionManager(this);
    public Player player= new Player(this, keyH);






    // creer un un panel qui va prendre toutes les info utiles de l'ecran pour y afficher
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }


    public void startGameThread(){
        gameThread=new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval=1000000000/FPS; //L'intervalle ou on va mettre a jour l'ecran en nansec
        double delta=0;
        long lastTime=System.nanoTime();
        long currentTime;
        long timer=0;
        int drawCount=0;

       while ( gameThread !=null){
        //Gestion de la MAJ de l'ecran
           currentTime=System.nanoTime();
           delta +=(currentTime- lastTime)/drawInterval;
           timer+=(currentTime-lastTime);
           lastTime=currentTime;

           if(delta >=1){
               update();
               repaint();
               delta--;
               drawCount++;
           }

           if(timer>= 1000000000){
               timer=0;
               drawCount=0;
           }


       }
    }

    public void update(){
        player.update();
    }

    //Methode pour dessiner avec Jpanel
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        // on modifie car c'est mieux pour faire un jeux que en 2D
        Graphics2D g2= (Graphics2D) g;

        tileM.draw(g2);



        player.draw(g2);
        //Une fois afficher le pc peut y enlever de la memoire( c'est pour pas surcharger la ram)
        g2.dispose();
    }
}
