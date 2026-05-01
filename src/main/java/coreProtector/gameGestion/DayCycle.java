package coreProtector.gameGestion;

import coreProtector.entity.Player;


public class DayCycle{

    GamePanel gp;
    public  int frameCounter = 0;
    public  int day = 1;
    public  int hour = 21;
    public  int min = 16 ;
    public  String realDay;
    public  String realHour;
    public  String realMin;
    public boolean night;


    public  void date( ){



        if (frameCounter == 6){

            frameCounter = 0;
            min += 1;
        }

        if (min == 60){

            min = 0;
            hour += 1;
        }

        if (hour == 24){

            hour = 0;
            day += 1;
        }


    }

    public void update(){
        frameCounter++;
        date();
        realDate();


    }

    // valeur qui va etre affichée dans le jeu (pour afficher 09 au lieu de 9)
    public void realDate(){
        if(min < 10){
            realMin = "0" + min;

        }else{
            realMin = "" + min;
        }

        if(hour < 10){
            realHour = "0" + hour;

        }else{
            realHour = "" + hour;
        }

        if(day < 10){
            realDay = "00" + day;

        } else if(day < 99) {
            realDay = "0" + day;

        }else{
            realDay = "" + day;
        }
    }


}
