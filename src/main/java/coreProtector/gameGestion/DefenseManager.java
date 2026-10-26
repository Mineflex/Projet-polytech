package coreProtector.gameGestion;

import coreProtector.entity.Defenses;

import javax.imageio.ImageIO;
import java.awt.Graphics ;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class DefenseManager {

    private GamePanel playing;
    private BufferedImage[]DefenseImages;
    private Defenses[] defenses;
    public DefenseManager(GamePanel playing){
        this.playing=playing;
        loadDefenseImages();
        InitDefenses();
    }
    public void addDefense(int x,int y) {
        for(int i=0;i<defenses.length;i++){
            if (defenses[i]==null){
                defenses[i] = new Defenses();
                defenses[i].setX(x);
                defenses[i].setY(y);
                System.out.println("cannon à X:"+x+"Y:"+y);
                break;
            }
        }
    }
    private void InitDefenses(){
        defenses = new Defenses[100];
        defenses[0] = new Defenses();
        defenses[0].setX(playing.player.worldx + (playing.tileSize * 2));
        defenses[0].setY(playing.player.worldy);
    }
    private void loadDefenseImages(){
        DefenseImages=new BufferedImage[16];
        try{
            DefenseImages[0]= ImageIO.read(getClass().getResourceAsStream("/defense/canon/lvl1_canon_sprite00.png"));
            DefenseImages[1]= ImageIO.read(getClass().getResourceAsStream("/defense/canon/lvl1_canon_sprite01.png"));
            DefenseImages[2]= ImageIO.read(getClass().getResourceAsStream("/defense/canon/lvl1_canon_sprite02.png"));
            DefenseImages[3]= ImageIO.read(getClass().getResourceAsStream("/defense/canon/lvl1_canon_sprite03.png"));
            DefenseImages[4]= ImageIO.read(getClass().getResourceAsStream("/defense/canon/lvl1_canon_sprite04.png"));
            DefenseImages[5]= ImageIO.read(getClass().getResourceAsStream("/defense/canon/lvl1_canon_sprite05.png"));
            DefenseImages[6]= ImageIO.read(getClass().getResourceAsStream("/defense/canon/lvl1_canon_sprite06.png"));
            DefenseImages[7]= ImageIO.read(getClass().getResourceAsStream("/defense/canon/lvl1_canon_sprite07.png"));
            DefenseImages[8]= ImageIO.read(getClass().getResourceAsStream("/defense/canon/lvl1_canon_sprite08.png"));
            DefenseImages[9]= ImageIO.read(getClass().getResourceAsStream("/defense/canon/lvl1_canon_sprite09.png"));
            DefenseImages[10]= ImageIO.read(getClass().getResourceAsStream("/defense/canon/lvl1_canon_sprite10.png"));
            DefenseImages[11]= ImageIO.read(getClass().getResourceAsStream("/defense/canon/lvl1_canon_sprite11.png"));
            DefenseImages[12]= ImageIO.read(getClass().getResourceAsStream("/defense/canon/lvl1_canon_sprite12.png"));
            DefenseImages[13]= ImageIO.read(getClass().getResourceAsStream("/defense/canon/lvl1_canon_sprite13.png"));
            DefenseImages[14]= ImageIO.read(getClass().getResourceAsStream("/defense/canon/lvl1_canon_sprite14.png"));
            DefenseImages[15]= ImageIO.read(getClass().getResourceAsStream("/defense/canon/lvl1_canon_sprite15.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void update(){

    }
    public void draw(Graphics g) {
        for (int i = 0; i < defenses.length; i++) {
            if (defenses[i] != null) {
                int worldX = defenses[i].getX();
                int worldY = defenses[i].getY();


                int screenX = worldX - playing.player.worldx + playing.player.screenX;
                int screenY = worldY - playing.player.worldy + playing.player.screenY;
                    g.drawImage(DefenseImages[0], screenX, screenY, playing.tileSize, playing.tileSize, null);
                }
            }
        }
    }


