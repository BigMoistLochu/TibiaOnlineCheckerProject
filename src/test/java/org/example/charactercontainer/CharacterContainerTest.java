package org.example.charactercontainer;

import org.example.charactercontainer.models.Character;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class CharacterContainerTest {

    private final Map<String, Character> characterMapForTest = CharacterContainer.getCharacterMap();

    @BeforeEach
    public void cleanMap() {
        characterMapForTest.clear();
    }

    public List<Character> createSomeCharacter(){
        List<Character> characterList = new ArrayList<>();
        Character character = new Character("DawidekTucznik");
        Character character2 = new Character("DawidekTucznik");
        Character character3 = new Character("PawelZborzy");
        Character character4 = new Character("PawelZbogdanca");
        characterList.add(character);
        characterList.add(character2);
        characterList.add(character3);
        characterList.add(character4);
        return characterList;
    }

    @Test
    void addCharacterToContainer() {
        List<Character> characters = createSomeCharacter();
        for(Character character: characters){
            CharacterContainer.addCharacterToContainer(character);
        }
        Assertions.assertEquals(3,characterMapForTest.size());
    }

    @Test
    void getAllExperiencedPlayers() {
        List<Character> characters = createSomeCharacter();
        for(Character character: characters){
            if(character.getNick().equals("PawelZbogdanca")) character.setIsExp(true);
            CharacterContainer.addCharacterToContainer(character);
        }

        List<Character> charactersExperienced = CharacterContainer.getAllExperiencedPlayers();

        Assertions.assertEquals(1,charactersExperienced.size());
        Assertions.assertEquals(charactersExperienced.getFirst().getNick(),"PawelZbogdanca");
        Assertions.assertTrue(charactersExperienced.getFirst().isExp());
    }

    @Test
    void getCharacterByNameShouldReturnCorrectCharacterIfCharacterIsInContain() {
        List<Character> characters = createSomeCharacter();
        for(Character character: characters){
            CharacterContainer.addCharacterToContainer(character);
        }
        Character selectedCharacter = CharacterContainer.getCharacterMap().get("PawelZborzy");
        Assertions.assertNotNull(selectedCharacter);
        Assertions.assertEquals("PawelZborzy", selectedCharacter.getNick());
    }

    @Test
    void getCharacterByNameShouldReturnNullWhenCharacterIsAbsent() {
        Character selectedCharacter = CharacterContainer.getCharacterMap().get("PawelZborzy");;
        Assertions.assertNull(selectedCharacter);
    }





}