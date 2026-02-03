package coreProtector;

import coreProtector.gameGestion.GamePanel;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Main {

    public static  void  main(String[] args){
        //Pas important, ca sert juste a evité le gap entre les tiles quand on bouge
        System.setProperty("sun.java2d.opengl", "true");
        JFrame window= new JFrame();
        // /!\ important pour que l'on puisse quitter le jeux, sinon on est bloqué...
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Le nom de la fenetre, ici du jeux ducoup
        window.setTitle("Core Protector");
        window.setResizable(false);



        // on applique le panel CF GamePanel
        GamePanel gamePanel= new GamePanel();
        window.add(gamePanel);

        window.pack(); // pour que le panel soit visible
        window.setLocationRelativeTo(null); // pour que la fenetre soit au centre
        window.setVisible(true);//pour que la fenetre soit visible

        gamePanel.startGameThread();
//
    }
}
