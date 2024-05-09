package org.example;

import org.example.http.SendMessageToDiscord;
import org.example.http.models.Embed;
import org.example.http.models.Message;
import org.example.scheduler.Scheduler;
import org.example.webscrapper.Scrapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

//        Scrapper scrapper = new Scrapper("https://www.ixodus.net/character/show/Zmiekczacz");
//        scrapper.getScrapp();

//            Message message = new Message("Tomek Dominator","Osoby aktualnie expiace:");
//            List<Embed> embedList = new ArrayList<>();
//            Embed embed = new Embed("Pedro","Aktualnie expi");
//            Embed embed1 = new Embed("Zdzira","Aktualnie expi");
//            embedList.add(embed);
//            embedList.add(embed1);
//            message.setEmbeds(embedList);
//
//            int sendMessageToDiscord = new SendMessageToDiscord()
//                .setWebHookURL("https://discord.com/api/webhooks/1229941706766684230/CrpSrtDshk-Vy7SgdgBhbKe4usHLOsX_NPD7Zm-IoK6vCD_xG8JU_N1yWKSUdqxnPz8n")
//                .sendMessageToDiscordWeebHook(message);

         Scheduler scheduler = new Scheduler();

    }


}