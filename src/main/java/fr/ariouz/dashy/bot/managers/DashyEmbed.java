package fr.ariouz.dashy.bot.managers;

import fr.ariouz.dashy.bot.entities.messages.DashyEmbedType;
import fr.ariouz.dashy.bot.run.DashyStarter;
import net.dv8tion.jda.api.EmbedBuilder;

import java.time.LocalDateTime;

public class DashyEmbed {

    private final DashyStarter dashyStarter;

    public DashyEmbed(DashyStarter dashyStarter){
        this.dashyStarter = dashyStarter;
    }

    public EmbedBuilder generate(DashyEmbedType dashyEmbedType, String title){
        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setColor(dashyEmbedType.getEmbedColor());
        embedBuilder.setTitle(title);
        embedBuilder.setFooter("Dashy - https://dashy-bot.xyz");
        embedBuilder.setTimestamp(LocalDateTime.now());

        return embedBuilder;
    }

}
