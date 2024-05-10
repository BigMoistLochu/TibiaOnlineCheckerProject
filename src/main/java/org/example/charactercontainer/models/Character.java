package org.example.charactercontainer.models;

public class Character {

    private String nick;

    private int experience;

    private boolean isExp;

    public Character(String nick) {
        this.nick = nick;
    }

    public Character(String nick,String exp) {
        if((nick==null) || (nick.isEmpty())) throw new IllegalArgumentException("Zly nick");
        this.nick = nick;

        if((exp==null) || (exp.isEmpty())) throw new IllegalArgumentException("String reprezentujacy exp nie moze byc nullem albo byc pusty");
        if(!exp.matches(".*[0-9].*")) throw new IllegalArgumentException("String reprezentujacy exp nie ma zadnych liczb w sobie");

        try {
            String expWithoutComma = exp.replace(",", "");
            this.experience = Integer.parseInt(expWithoutComma);
        }catch (NumberFormatException numberFormatException){
            throw new IllegalArgumentException("Blad przy parsowaniu stringa na inta");
        }
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }


    public boolean isExp() {
        return isExp;
    }

    public void setIsExp(boolean exp) {
        isExp = exp;
    }
}
