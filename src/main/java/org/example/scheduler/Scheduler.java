package org.example.scheduler;


import org.example.scheduler.tasks.ScrappCharacterFromWebsiteTask;
import org.example.scheduler.tasks.SendDiscordMessageAfterScanCharacterContainerTask;
import java.util.Timer;


public final class Scheduler {

    private static Scheduler INSTANCE;
    private Scheduler(){
        Timer timer = new Timer();
        //wszystkie zadania ktore beda wykonywane co okreslona ilosc min
        timer.schedule(new ScrappCharacterFromWebsiteTask(),0,6*60*1000);  //co 6 min beda scrappowane postacie
        timer.schedule(new SendDiscordMessageAfterScanCharacterContainerTask(),0,7*60*1000); //co 7 min bedzie zachodzil skan postaci
    }

    public synchronized static Scheduler createSchedulerInstance(){
        if(INSTANCE==null){
            INSTANCE = new Scheduler();
        }

        return INSTANCE;
    }

}
