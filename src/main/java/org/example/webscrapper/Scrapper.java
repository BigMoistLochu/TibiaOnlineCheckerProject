package org.example.webscrapper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Scrapper {
    private Document doc;
    public Scrapper(String link) throws IOException {
        doc = Jsoup.connect(link).timeout(5000)
                .userAgent("Mozilla")
                .get();
    }

    public void getScrapp()
    {
        System.out.println(doc.select("table.guild-list:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2) > font:nth-child(1) > strong:nth-child(1)").outerHtml());
    }

}
