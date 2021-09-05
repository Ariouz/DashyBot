package fr.ariouz.dashy.bot.entities.commands;

import fr.ariouz.dashy.bot.commands.utils.UptimeCommand;
import net.dv8tion.jda.api.Permission;

import java.util.Arrays;

public enum Commands {

    UPTIME("uptime", "Get bot uptime", Permission.MANAGE_CHANNEL, CommandCategories.UTILITIES, UptimeCommand.class),

    ;

    private final String identifier;
    private final String description;
    private final Permission permission;
    private final CommandCategories commandCategory;
    private final Class commandClass;

    Commands(String identifier, String description, Permission permission, CommandCategories category, Class commandClass){
        this.identifier = identifier;
        this.description = description;
        this.permission = permission;
        this.commandCategory = category;
        this.commandClass = commandClass;
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

    public Class getCommandClass() {
        return commandClass;
    }

    public static Commands getByIdentifier(String identifier){
        return Arrays.stream(values()).filter(t -> identifier.equals(t.getIdentifier())).findFirst().orElse(null);
    }

}
