package org.example;

import org.example.http.SendMessageToDiscord;
import org.example.http.models.Message;
import org.example.webscrapper.Scrapper;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scrapper scrapper = new Scrapper("https://www.ixodus.net/character/show/Heimerdinger");
        scrapper.getScrapp();


//            int sendMessageToDiscord = new SendMessageToDiscord()
//                .setWebHookURL("https://discord.com/api/webhooks/1229941706766684230/CrpSrtDshk-Vy7SgdgBhbKe4usHLOsX_NPD7Zm-IoK6vCD_xG8JU_N1yWKSUdqxnPz8n")
//                .sendMessageToDiscordWeebHook(new Message("Pani od Elektroniki","Siema tomek co robisz po lekcjach?"));

    }


}