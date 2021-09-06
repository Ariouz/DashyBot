package fr.ariouz.dashy.bot.commands.utils;

import fr.ariouz.dashy.bot.entities.commands.Commands;
import fr.ariouz.dashy.bot.entities.commands.DashyCommand;
import fr.ariouz.dashy.bot.entities.messages.DashyEmbedType;
import fr.ariouz.dashy.bot.run.DashyStarter;
import fr.ariouz.dashy.bot.time.TimeConverter;
import fr.ariouz.dashy.bot.time.TimeFormat;
import fr.ariouz.dashy.bot.time.TimeUtil;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class UptimeCommand extends DashyCommand {

    public UptimeCommand(Commands command, DashyStarter dashyStarter) {
        super(command, dashyStarter);
    }

    @Override
    public void execute(GuildMessageReceivedEvent event, String[] args){
        long uptime = System.currentTimeMillis() - getDashyStarter().getStartTime();

        EmbedBuilder embedBuilder = getDashyStarter().getBotManager().getMessageManager().getDashyEmbed().generate(DashyEmbedType.INFO, "Bot Uptime")
                .setDescription("Hey "+event.getAuthor().getAsMention()+" ! :wave: I'm online since " + new TimeConverter().from(TimeUtil.MILLIS, getDashyStarter().getStartTime()).parse(TimeFormat.YEAR) +
                        " ("+ new TimeConverter().from(TimeUtil.MILLIS, uptime).parseToStringDays(":") +").");
        event.getChannel().sendMessageEmbeds(embedBuilder.build()).queue();
    }

}
