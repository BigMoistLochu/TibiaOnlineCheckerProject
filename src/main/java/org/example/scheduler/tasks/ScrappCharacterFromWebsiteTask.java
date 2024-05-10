package org.example.scheduler.tasks;


import org.example.webscrapper.Scrapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class ScrappCharacterFromWebsiteTask extends TimerTask {

    //lista linkow do odwiedzenia...
    private List<String> linksListToScrapp = new ArrayList<>(List.of(
            "https://www.ixodus.net/character/show/Lochu",
            "https://www.ixodus.net/character/show/Zmiekczacz",
            "https://www.ixodus.net/character/show/Rash'hero_Edek",
            "https://www.ixodus.net/character/show/Mientki",
            "https://www.ixodus.net/character/show/Man_Like_Shotta",
            "https://www.ixodus.net/character/show/Moo_Ms",
            "https://www.ixodus.net/character/show/Luckky",
            "https://www.ixodus.net/character/show/Pekina",
            "https://www.ixodus.net/character/show/Komek",
            "https://www.ixodus.net/character/show/Terrorysta_Jebany",
            "https://www.ixodus.net/character/show/Kamisek",
            "https://www.ixodus.net/character/show/Ten_Po_Amarenie",
            "https://www.ixodus.net/character/show/Mix's"));


    @Override
    public void run() {
        //dla kazdego linku tworzy sie scrapper

        for(String link: linksListToScrapp){
            Thread thread = new Thread(()->{
                System.out.println("Uruchomiono:"+ Thread.currentThread());
                try {
                    Scrapper scrapper = new Scrapper(link);
                    scrapper.getScrapp();
                } catch (IOException e) {
                    System.out.println("Pojawil sie blad przy tworzeniu Scrappera na watku:"+Thread.currentThread());
                }
            });
            thread.start();
        }


    }
}
