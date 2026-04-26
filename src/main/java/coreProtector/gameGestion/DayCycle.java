package coreProtector.gameGestion;

import coreProtector.entity.Player;


public class DayCycle{

    public static int frameCounter = 0;
    public static int day = 1;
    public static int hour = 0;
    public static int min = 0 ;
    public static String realDay;
    public static String realHour;
    public static String realMin;


    public static void date(){

        frameCounter++;

        // 7200 frame correspond à peu près à une min
        if (frameCounter == 7200){

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

    // valeur qui va etre affichée dans le jeu (pour afficher 09 au lieu de 9)
    public static void realDate(){
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
