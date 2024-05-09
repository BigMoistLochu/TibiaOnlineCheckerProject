package org.example.charactercontainer;

import org.example.charactercontainer.models.Character;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CharacterContainer {
    private static final Map<String, Character> characterMap = new HashMap<>();

    public synchronized static void addCharacterToContainer(Character newCharacter){
        if(!characterMap.containsKey(newCharacter.getNick())){
            characterMap.put(newCharacter.getNick(),newCharacter);
        }
    }

    public static Map<String, Character> getCharacterMap() {
        return characterMap;
    }

    public static List<Character> getAllExperiencedPlayers(){
        List<Character> listExperiencedPlayers = new ArrayList<>();
        characterMap.forEach((key,value)->{
            if(value.isExp()) listExperiencedPlayers.add(value);
        });
        return listExperiencedPlayers;
    }


    public static Character getCharacterByName(String name)
    {
        if(!characterMap.containsKey(name)) return null;
        return characterMap.get(name);
    }


    public static Character createCharacterByCredentials(String nick,String exp){
        Character character = new Character(nick);
        character.setIsExp(false);
        return character;
    }

    public static boolean checkIsPlayerExp(String name,String newExperience){
        Character character = getCharacterByName(name);
        //Tutaj sprawdzenie warunku czy (nowy exp-stary exp>0)


        return true;
    }

    //ta funkcje bedziesz w sumie wywolywal non stop
    public static void checkCharacter(String nick,String exp) {
        //1.Sprawdz czy nick sie juz znajduje w liscie
        if(!characterMap.containsKey(nick)) createCharacterByCredentials(nick,exp);
        else {
            //char znajduje sie w liscie to wiemy
        }

    }

    //funkcja ktora sprawdza czy ktos expi
    //webscrapper bedzie wchodzi na strone non stop->odwola sie do konenera
    //1.Dodaj postac
    //2.jesli postac jest to sprawdz czy dane sie nie zmienili(nowy exp-stary exp>0))
    //3.jesli sie zmienily to zaktualizuj stan isExp


}
