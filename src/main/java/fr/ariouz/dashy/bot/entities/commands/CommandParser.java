package fr.ariouz.dashy.bot.entities.commands;

import fr.ariouz.dashy.bot.entities.messages.DashyEmbedType;
import fr.ariouz.dashy.bot.run.DashyStarter;
import fr.ariouz.dashy.bot.system.logger.LogAction;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CommandParser extends ListenerAdapter {

    private final DashyStarter dashyStarter;

    public CommandParser(DashyStarter dashyStarter){
        this.dashyStarter = dashyStarter;
    }

    public void parse(String identifier, GuildMessageReceivedEvent event, String[] args){
        if(event.getAuthor() == dashyStarter.getDashyJDA().getSelfUser()) return;
        if(identifier == null || identifier.equals("")) return;

        if(Commands.getByIdentifier(identifier) == null){
            dashyStarter.getLogger().log(LogAction.ERROR, "Failed to parse command " + identifier+".");
            return;
        }

        Commands command = Commands.getByIdentifier(identifier);
        for(Commands cmds : Commands.values()){
            if(cmds.getCommandClass() == command.getCommandClass()){
                User user = event.getAuthor();
                if(event.getGuild().getMember(user) == null) return;
                if(!event.getGuild().getMember(user).hasPermission(cmds.getPermission())){
                    dashyStarter.getLogger().log(LogAction.COMMAND, " " + user.getName() + user.getDiscriminator() + "(" + user.getId() + ") tried to use command " + command.getIdentifier() +" but didn't have right permission.");
                    EmbedBuilder embedBuilder = dashyStarter.getBotManager().getMessageManager().getDashyEmbed().generate(DashyEmbedType.PERMISSION, "No Permission")
                            .setDescription("You need ```" + cmds.getPermission().getName() + "``` permission to use this command !");
                    event.getChannel().sendMessageEmbeds(embedBuilder.build()).queue();
                    return;
                }

                dashyStarter.getLogger().log(LogAction.COMMAND, " " + user.getName() + user.getDiscriminator() + "(" + user.getId() + ") used command " + command.getIdentifier()+".");
                dashyStarter.getBotManager().getCommandsManager().getCommands().get(cmds).execute(event, args);
                break;
            }
        }

    }

    public DashyStarter getDashyStarter() {
        return dashyStarter;
    }

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String[] args = event.getMessage().getContentRaw().split(" ");
        if(args[0].contains(dashyStarter.getPrefix())){
            String identifier = args[0].replaceFirst(dashyStarter.getPrefix(), "");
            parse(identifier, event, args);
        }
    }

}
