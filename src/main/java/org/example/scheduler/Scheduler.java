package org.example.scheduler;

import org.example.charactercontainer.CharacterContainer;
import org.example.charactercontainer.models.Character;
import org.example.http.SendMessageToDiscord;
import org.example.http.models.Embed;
import org.example.http.models.Message;
import org.example.webscrapper.Scrapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Scheduler {


    public Scheduler(){


                TimerTask taskForScrapper = new TimerTask() {
            @Override
            public void run() {
                Scrapper scrapper = null;
                try {
                    scrapper = new Scrapper("https://www.ixodus.net/character/show/Lochu");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                scrapper.getScrapp();
            }
        };

        TimerTask taskForDiscord = new TimerTask() {
            @Override
            public void run() {
                Message message = new Message("Tomek Dominator","Osoby aktualnie expiace:");
                List<Embed> embedList = new ArrayList<>();
                if(!CharacterContainer.getAllExperiencedPlayers().isEmpty()){
                    for (Character character: CharacterContainer.getAllExperiencedPlayers()){
                        embedList.add(new Embed(character.getNick(),"Aktualnie expi"));
                    }

                    message.setEmbeds(embedList);

                    try {
                        int sendMessageToDiscord = new SendMessageToDiscord()
                                .setWebHookURL("https://discord.com/api/webhooks/1229941706766684230/CrpSrtDshk-Vy7SgdgBhbKe4usHLOsX_NPD7Zm-IoK6vCD_xG8JU_N1yWKSUdqxnPz8n")
                                .sendMessageToDiscordWeebHook(message);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };



        //scrapuj dane co 3min
        //wysylaj na discord co 5min aktualny stan listy

        Timer timer = new Timer();
        timer.schedule(taskForScrapper,0,3*60*1000);
        timer.schedule(taskForDiscord,0,4*60*1000);
        //scheduler.schedule(taskForPracujPL,0,10*60*1000);
        //        scheduler.schedule(taskForJustJoinIt,0,10*60*1000);

    }




    //TimerTask task = new TimerTask() {
    //        public void run() {
    //            System.out.println("Task performed on: " + new Date() + "n" +
    //              "Thread's name: " + Thread.currentThread().getName());
    //        }
    //    };
    //    Timer timer = new Timer("Timer");
    //
    //    long delay = 1000L;
    //    timer.schedule(task, delay);
}
