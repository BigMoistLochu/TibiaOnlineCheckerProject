package org.example.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.http.models.Message;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class SendMessageToDiscord {
    private final ObjectMapper mapperJson = new ObjectMapper();
    private URL webhookendpoint;

    public SendMessageToDiscord setWebHookURL(String webhookUrl)
    {
        try{
            webhookendpoint = URI.create(webhookUrl).toURL();
        }catch(MalformedURLException malformedURLException){
            System.out.println("Blad podczas ustawiania webhooka: "
                    +malformedURLException.getMessage());
        }
        return this;
    }

    public int sendMessageToDiscordWeebHook(Message message) throws IOException {
        //otwieranie polaczenia z webhookiem
        HttpURLConnection con = (HttpURLConnection) webhookendpoint.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");
        con.setDoOutput(true);


        OutputStream conOutputStream = con.getOutputStream();
        //wyslanie obiektu json do webhooka jako ciag bajtow
        conOutputStream.write(mapperJson.writeValueAsBytes(message));
        conOutputStream.flush();
        conOutputStream.close();

        int responseStatus = con.getResponseCode();
        if(responseStatus==204) System.out.println("pomyslnie wyslano nowa wiadomosc na discord");
        else System.out.println("cos poszlo nie tak kod:" + responseStatus);
        return responseStatus;
    }
}
