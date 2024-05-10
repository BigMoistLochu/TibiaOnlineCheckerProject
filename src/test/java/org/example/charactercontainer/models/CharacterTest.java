package org.example.charactercontainer.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CharacterTest {

    @Test
    public void CreateCharacterWithEmptyNickParameterThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class,()->new Character("","49213"),"Zly nick");
    }

    @Test
    public void CreateCharacterWithNullNickParameterThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class,()->new Character(null,"49213"),"Zly nick");
    }

    @Test
    public void CreateCharacterWithNullExpParameterThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class,()->new Character("Dziku",null),"String reprezentujacy exp nie moze byc nullem albo byc pusty");
    }

    @Test
    public void CreateCharacterWithEmptyExpParameterThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class,()->new Character("Dziku",""),"String reprezentujacy exp nie moze byc nullem albo byc pusty");
    }

    @Test
    public void CreateCharacterWithoutNumbersInExpParameterThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class,()->new Character("Dziku","no numbers"),"String reprezentujacy exp nie ma zadnych liczb w sobie");
    }



}