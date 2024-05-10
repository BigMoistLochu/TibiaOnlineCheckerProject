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
        return new ArrayList<>(List.of(new Character("DawidekTucznik"),
                new Character("DawidekTucznik"),
                new Character("PawelZborzy"),
                new Character("PawelZbogdanca")));
    }

    @Test
    void addCharacterToContainerShouldAddUniqueNickToMap() {
        createSomeCharacter()
                .forEach(character -> CharacterContainer.addCharacterToContainer(character));
        Assertions.assertEquals(3,characterMapForTest.size());
        Assertions.assertNotEquals(4,characterMapForTest.size());
    }

    @Test
    void getAllExperiencedPlayersListShouldReturnOnlyOneCharacterWithStatusIsExpTrue() {
        createSomeCharacter().forEach(character -> {
            if(character.getNick().equals("PawelZbogdanca")){
                character.setIsExp(true);
                CharacterContainer.addCharacterToContainer(character);
            }
        });
        List<Character> charactersExperienced = CharacterContainer.getAllExperiencedPlayers();

        Assertions.assertEquals(1,charactersExperienced.size());
        Assertions.assertEquals(charactersExperienced.getFirst().getNick(),"PawelZbogdanca");
        Assertions.assertTrue(charactersExperienced.getFirst().isExp());
    }

    @Test
    void getCharacterByKeyShouldReturnNullWhenCharacterIsAbsent() {
        Character selectedCharacter = CharacterContainer.getCharacterMap().get("PawelZborzy");
        Assertions.assertNull(selectedCharacter);
    }





}