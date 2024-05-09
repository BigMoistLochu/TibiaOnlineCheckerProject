package org.example.webscrapper;

import org.example.charactercontainer.CharacterContainer;
import org.example.charactercontainer.models.Character;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

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
        try {
            Character character = new Character(getNickByCssSelector(),getExperienceCssSelector());
            CharacterContainer.uploadCharacter(character);
        }
        catch (IllegalArgumentException e){
            System.out.println("Nieudana proba ze scrappowania postaci blad: "+ e.getMessage());
        }


    }

    private String getNickByCssSelector() {
        Element element = doc.selectFirst("table.guild-list:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2) > font:nth-child(1) > strong:nth-child(1)");
        if(element==null) return null;
        if(!element.hasText())  return null;
        return element.text();
    }

    private String getExperienceCssSelector() {
        Element element = doc.selectFirst("table.guild-list:nth-child(4) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(2) > strong:nth-child(1)");
        if(element==null) return null;
        if(!element.hasText())  return null;
        return element.text();
    }

}
