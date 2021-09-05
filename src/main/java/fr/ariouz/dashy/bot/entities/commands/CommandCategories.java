package fr.ariouz.dashy.bot.entities.commands;

public enum CommandCategories {

    ADMIN("admin"),
    MODERATION("moderation"),
    UTILITIES("utilities"),
    OTHER("others");

    private final String identifier;

    CommandCategories(String identifier){
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }
}
