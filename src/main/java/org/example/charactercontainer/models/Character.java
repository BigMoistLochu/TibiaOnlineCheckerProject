package org.example.charactercontainer.models;

public class Character {

    private String nick;

    private String experience;

    private boolean isExp;

    public Character(String nick) {
        this.nick = nick;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public boolean isExp() {
        return isExp;
    }

    public void setIsExp(boolean exp) {
        isExp = exp;
    }
}
