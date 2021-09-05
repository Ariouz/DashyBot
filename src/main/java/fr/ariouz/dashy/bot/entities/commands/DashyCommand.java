package fr.ariouz.dashy.bot.entities.commands;

import fr.ariouz.dashy.bot.run.DashyStarter;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class DashyCommand {

    private final String identifier;
    private final String description;
    private final Permission permission;
    private final CommandCategories commandCategory;

    private final DashyStarter dashyStarter;

    public DashyCommand(Commands command, DashyStarter dashyStarter){
        this.identifier = command.getIdentifier();
        this.description = command.getDescription();
        this.permission = command.getPermission();
        this.commandCategory = command.getCommandCategory();
        this.dashyStarter = dashyStarter;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getDescription() {
        return description;
    }

    public Permission getPermission() {
        return permission;
    }

    public CommandCategories getCommandCategory() {
        return commandCategory;
    }

    public void execute(GuildMessageReceivedEvent event, String[] args){ }

    public DashyStarter getDashyStarter() {
        return dashyStarter;
    }
}
