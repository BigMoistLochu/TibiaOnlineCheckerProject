package org.example.scheduler.tasks;

import org.example.charactercontainer.CharacterContainer;
import org.example.charactercontainer.models.Character;
import org.example.http.SendMessageToDiscord;
import org.example.http.models.Embed;
import org.example.http.models.Message;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class SendDiscordMessageAfterScanCharacterContainerTask extends TimerTask {
    @Override
    public void run() {
        if(!CharacterContainer.getAllExperiencedPlayers().isEmpty()){

            Message message = new Message("Tomek Dominator","Osoby aktualnie expiace:");
            List<Embed> embedList = new ArrayList<>();

            for (Character character: CharacterContainer.getAllExperiencedPlayers()){
                embedList.add(new Embed(character.getNick(),"Aktualnie expi i wbil dzis: "+character.getExperience()+" exp"));
            }

            message.setEmbeds(embedList);

            try {
                int sendMessageToDiscord = new SendMessageToDiscord()
                        .setWebHookURL("https://discord.com/api/webhooks/1238253114482495521/-fT4q1_GXUPL7eSYuwWWHZo50hcA3FW6y0mjrv44R49H7hfxt3D0bzJhiKZgdU5bN6Xd")
                        .sendMessageToDiscordWeebHook(message);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
