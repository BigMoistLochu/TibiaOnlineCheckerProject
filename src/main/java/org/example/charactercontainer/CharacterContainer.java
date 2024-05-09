package org.example.charactercontainer;

import org.example.charactercontainer.models.Character;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CharacterContainer {
    private static final Map<String, Character> characterMap = new HashMap<>();

    public static Map<String, Character> getCharacterMap() {
        return characterMap;
    }

    public synchronized static void addCharacterToContainer(Character newCharacter){
        if(!characterMap.containsKey(newCharacter.getNick())){
            characterMap.put(newCharacter.getNick(),newCharacter);
        }
    }

    public static List<Character> getAllExperiencedPlayers(){
        List<Character> listExperiencedPlayers = new ArrayList<>();
        characterMap.forEach((key,value)->{
            if(value.isExp()) listExperiencedPlayers.add(value);
        });
        return listExperiencedPlayers;
    }

    //BELOW EVERYTHING IS FOR SCRAPPER

    public static void uploadCharacter(Character character) {
        if(characterMap.containsKey(character.getNick())){
            if(updateExpIfChanged(character.getNick(), character.getExperience())){
                System.out.println("Pomyslnie zaktualizowano postac o nicku:" + character.getNick());
            }else {
                System.out.println("Cos poszlo nie tak przy aktualizacji postaci o nicku: " + character.getNick());
            }
        }
        else{
            addCharacterToContainer(character);
            System.out.println("Dodano postac do CharacterContainera o nicku:" + character.getNick());
        }
    }
    private static boolean updateExpIfChanged(String name,int newExperience){
        Character characterToUpdate = characterMap.get(name);
        int oldExperience = characterToUpdate.getExperience();

        if(Math.abs(newExperience-oldExperience)>0){
            //jesli nie bedzie mial ustawionego statusu ze expi to zmien to
            if(!characterToUpdate.isExp()) characterToUpdate.setIsExp(true);
            //zmien mu expa zeby przy ponownym mial juz zaktualizowane to
            characterToUpdate.setExperience(newExperience);
            //zaktualizuj dana postac w mapie
            characterMap.put(characterToUpdate.getNick(),characterToUpdate);
            return true;
        }

        if(Math.abs(newExperience-oldExperience)<=0){
            if(characterToUpdate.isExp()) characterToUpdate.setIsExp(false);
            characterMap.put(characterToUpdate.getNick(),characterToUpdate);
            return true;
        }
        return false;
    }






}
