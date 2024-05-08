package org.example.http.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {

    @JsonProperty("username")
    private String nick;
    @JsonProperty("content")
    private String value;

    public Message(String nick, String value) {
        this.nick = nick;
        this.value = value;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
