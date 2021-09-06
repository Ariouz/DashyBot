package fr.ariouz.dashy.bot.time;

public enum TimeFormat {

    YEAR_FILE("yyyy.MM.dd.HH.mm.ss"),
    MONTH_FILE("MM.dd.HH.mm.ss"),
    DAY_FILE("dd.HH.mm.ss"),
    HOUR_FILE("HH.mm.ss"),
    MINUTE_FILE("mm.ss"),
    SECONDS_FILE("ss"),

    YEAR("yyyy-MM-dd HH:mm"),
    MONTH("MM-dd HH.mm"),
    DAY("dd HH:mm"),
    HOUR("HH:mm"),
    MINUTE("mm:ss"),
    SECONDS("ss"),

    ;

    private final String format;

    TimeFormat(String format){
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
