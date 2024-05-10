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
         Scheduler.createSchedulerInstance();
    }


}