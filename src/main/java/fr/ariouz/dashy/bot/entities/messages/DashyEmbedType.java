package fr.ariouz.dashy.bot.entities.messages;

import java.awt.*;

public enum DashyEmbedType {

    DEFAULT(new Color(0, 144, 255)),
    ERROR(new Color(183, 20, 20)),
    INFO(new Color(0, 186, 255)),
    PERMISSION(new Color(183, 20, 20)),
    WARN(new Color(199, 69, 15)),
    SUCCESS(new Color(29, 143, 2))

    ;

    private final Color embedColor;

    DashyEmbedType(Color embedColor){
        this.embedColor = embedColor;
    }

    public Color getEmbedColor() {
        return embedColor;
    }
}
