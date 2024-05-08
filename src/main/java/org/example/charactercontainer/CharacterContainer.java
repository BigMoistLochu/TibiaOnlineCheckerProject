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


}
