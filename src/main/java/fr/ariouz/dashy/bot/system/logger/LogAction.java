package fr.ariouz.dashy.bot.system.logger;

import fr.ariouz.dashy.bot.system.logger.color.ANSIColor;

public enum LogAction {

    DEFAULT("", ANSIColor.RESET),
    WARN("[WARN] ", ANSIColor.YELLOW),
    ERROR("[ERROR] ", ANSIColor.RED),
    INFO("[INFO] ", ANSIColor.CYAN),
    SUCCESS("[SUCCESS] ", ANSIColor.GREEN),
    COMMAND("[COMMAND]", ANSIColor.PURPLE);
    ;

    private final String suffix;
    private final ANSIColor color;

    LogAction(String suffix, ANSIColor color){
        this.suffix = suffix;
        this.color = color;
    }

    public String getSuffix() {
        return suffix;
    }

    public ANSIColor getColor() {
        return color;
    }
}
