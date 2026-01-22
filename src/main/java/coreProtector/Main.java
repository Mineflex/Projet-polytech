package coreProtector;

import coreProtector.gameGestion.GamePanel;

import javax.swing.*;

public class Main {

    public static  void  main(String[] args){
        JFrame window= new JFrame();
        // /!\ important pour que l'on puisse quitter le jeux, sinon on est bloqué...
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
