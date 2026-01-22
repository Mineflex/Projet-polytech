package coreProtector.gameGestion;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements  Runnable{
    //paramettres de l'ecran---------------

    final int originalTileSize=32; // la taille de chacun de nos sprites et tiles (pixel art)
    final int scale=2; // un multiplicateur pour augmenter la taille sur l'ecran car sinon tout est minuscule
    final int tileSize= originalTileSize*scale; // La taille visible, donc agrandie, en pixel de chaque sprites

    final int maxScreenCol=16; //Le nombre max de tiles en largeur sur l'ecran
    final int maxSreenRow=12; // idem mais en longueurs
    final int screenWidth=tileSize*maxScreenCol; // la taille final de l'ecran
    final int screenHeight=tileSize*maxSreenRow;//    ^
    //-------------------------------------

    int FPS=60;

    KeyHandler keyH= new KeyHandler();
    Thread gameThread;

    //position du joueur
    int playerX= 100;
    int playerY=100;
    int playerSpeed=4;
//a
    // creer un un panel qui va prendre toutes les info utiles de l'ecran pour y afficher
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
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
        double drawInterval=1000000000/FPS;
        double delta=0;
        long lastTime=System.nanoTime();
        long currentTime;
        long timer=0;
        int drawCount=0;

       while ( gameThread !=null){

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
               System.out.println("Fps :" +drawCount);
               timer=0;
               drawCount=0;
           }


       }
    }

    public void update(){
        if(keyH.upPressed==true){
            playerY-=playerSpeed;
        }
        else if(keyH.downPressed==true){
            playerY+=playerSpeed;
        }else if(keyH.leftPressed==true){
            playerX-=playerSpeed;
        }else if(keyH.rightPressed==true){
            playerX+=playerSpeed;
        }

        if (keyH.sprintPressed){
            playerSpeed=6;
        }else {
            playerSpeed=4;
        }
    }

    //Methode pour dessiner avec Jpanel
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        // on modifie car c'est mieux pour faire un jeux que en 2D
        Graphics2D g2= (Graphics2D) g;

        g2.setColor(Color.white);
        g2.fillRect(playerX,playerY,tileSize, tileSize);

        //Une fois afficher le pc peut y enlever de la memoire( c'est pour pas surcharger la ram)
        g2.dispose();
    }
}
